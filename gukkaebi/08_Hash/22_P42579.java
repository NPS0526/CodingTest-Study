import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // genres: ["classic", "pop", "classic", "classic", "pop"]
        // plays: [500, 600, 150, 800, 2500]
        // return: [4, 1, 3, 0]

        Map<String, List<int[]>> genresMap = new HashMap<>(); // {genre : {idx : play}}
        Map<String, Integer> totalPlaysMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            totalPlaysMap.put(genre, totalPlaysMap.getOrDefault(genre, 0) + play);
            genresMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[] { i, play });
        }

        List<String> genreRank = new ArrayList<>(totalPlaysMap.keySet());
        genreRank.sort((g1, g2) -> totalPlaysMap.get(g2) - totalPlaysMap.get(g1)); // g2 - g1 : 내림차순 정렬

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : genreRank) {
            List<int[]> songs = genresMap.get(genre); // {i, play} 저장

            songs.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0]; // play가 같으면 idx 기준 오름차순
                }
                return b[1] - a[1]; // 기본적으로는 play 기준 내림차순
            });

            bestAlbum.add(songs.get(0)[0]); // get(0)이 list에서는 순서임에 주의!

            if (songs.size() > 1)
                bestAlbum.add(songs.get(1)[0]);
        }

        int[] answer = new int[bestAlbum.size()];
        for (int i = 0; i < bestAlbum.size(); i++)
            answer[i] = bestAlbum.get(i);

        return answer;

    }

}