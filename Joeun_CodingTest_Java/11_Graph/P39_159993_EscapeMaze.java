
import java.util.*;

public class P39_159993_EscapeMaze {
    private static int[][] directions;
    private static String[] map;
    private static int N;
    private static int M;

    private static int[][] dist;
    private static ArrayDeque<int[]> queue;
    
    public int solution(String[] maps) {
        // 시작점 찾기
        int[] start = new int[2]; // 행, 열
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        for (int i = 0; i < maps.length; i++){
            String map = maps[i];
            
            int j = map.indexOf("S");
            if (j != -1)
                start = new int[]{i,j};
            
            j = map.indexOf("L");
            if (j != -1)
                lever = new int[]{i,j};
            
            j = map.indexOf("E");
            if (j != -1)
                exit = new int[]{i,j};
        }
        
        // 변수 초기화
        directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        map = maps;
        N = maps.length; // 행
        M = maps[0].length(); // 열
        
        int answer = 0;
        
        // bfs: start -> lever
        bfs(start);
        
        if (dist[lever[0]][lever[1]] == 0)
            return -1;
        else
            answer += dist[lever[0]][lever[1]];
        
        
        bfs(lever);
        if (dist[exit[0]][exit[1]] == 0)
            return -1;
        else
            answer += dist[exit[0]][exit[1]];
        
        return answer;
    }
    
    private static void bfs(int[] start){
        dist = new int[N][M];
        queue = new ArrayDeque<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            for (int[] dir : directions){
                int[] next = new int[]{now[0]+dir[0],now[1]+dir[1]};
                
                if (next[0] < 0 || next[0] > N-1 
                    || next[1] < 0 || next[1] > M-1)
                    continue;
                if (map[next[0]].charAt(next[1]) == 'X')
                    continue;
                
                if (dist[next[0]][next[1]] == 0){
                    dist[next[0]][next[1]] = dist[now[0]][now[1]] + 1;
                    queue.add(next);
                }
            }
            
        }
        
    }

    public static void main(String[] args) {
        P39_159993_EscapeMaze p = new P39_159993_EscapeMaze();
        System.out.println(p.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"})); // 16
        System.out.println(p.solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"})); // -1
    }
}