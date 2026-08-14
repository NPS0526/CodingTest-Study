package BackTracking;

import java.util.*;

public class P87946 {
    private static int[][] Dungeons;
    private static boolean[] visited;
    private static int answer;
    
    private static void backtrack(int k, int cnt){
        for(int i=0; i<Dungeons.length; i++){
            if(!visited[i] && Dungeons[i][0] <= k){
                visited[i] = true;
                backtrack(k-Dungeons[i][1], cnt+1);
                answer = Math.max(answer, cnt+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        backtrack(k, 0);
        return answer;
    }
}
