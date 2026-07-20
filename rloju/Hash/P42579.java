package Hash;

import java.util.*;

public class P42579 {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        Map<String, Long> genre_total = new HashMap<>();
        Map<String, List<int[]>> genre_songs = new HashMap<>(); // [play, index]
        
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            genre_total.put(genre, genre_total.getOrDefault(genre, 0L) + plays[i]);
            genre_songs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{plays[i], i});
        }
        
        List<String> sorted_genres = new ArrayList<>(genre_total.keySet());
        sorted_genres.sort((a, b) -> Long.compare(genre_total.get(b), genre_total.get(a)));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : sorted_genres) {
            List<int[]> songs = genre_songs.get(genre);
            songs.sort((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[1]);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
}
