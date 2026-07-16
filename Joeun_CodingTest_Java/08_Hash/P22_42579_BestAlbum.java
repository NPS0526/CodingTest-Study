import java.util.*;

public class P22_42579_BestAlbum { // 베스트 앨범
    public class Genre {
        String genre;
        int total_play;
        ArrayList<Song> song_list = new ArrayList<>();
        
        public Genre(String genre, int total_play){
            this.genre = genre;
            this.total_play = total_play;
        }
        
        public void sort_song(){
            song_list.sort((s1, s2) -> s2.cnt - s1.cnt);
            return;
        }
        
        public ArrayList<Integer> select_song(){
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < song_list.size(); i++){
                result.add(song_list.get(i).num);
                if (i == 1){
                    break;
                }
            }
            return result;
        }
    }
    public class Song {
        int num; // 고유 번호
        int cnt; // 재생 횟수
        
        public Song(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르 해시맵 초기화 - 장르 : 장르 클래스
        HashMap<String, Genre> genre_map = new HashMap<>();
        for (int i = 0; i < genres.length; i++){
            if (genre_map.containsKey(genres[i])){
                genre_map.get(genres[i]).total_play += plays[i];
            } else {
                genre_map.put(genres[i],new Genre(genres[i],plays[i]));
            }
            
            // 장르 클래스에 곡 추가
            genre_map.get(genres[i]).song_list.add(new Song(i,plays[i]));
        }
        
        // 정렬 - 1. 장르별 총 횟수 2. 각 장르 안의 곡 횟수
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Genre> genre_list = new ArrayList<>(genre_map.values());
        genre_list.sort((g1, g2) -> g2.total_play - g1.total_play);
        for (int i = 0; i < genre_list.size(); i++){
            genre_list.get(i).sort_song();
            result.addAll(genre_list.get(i).select_song());
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        P22_42579_BestAlbum p = new P22_42579_BestAlbum();
        System.out.println(Arrays.toString(p.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}))); // [4, 1, 3, 0]
    }
}