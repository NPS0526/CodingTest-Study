import java.util.*;

public class P37_1844_ShortestMapPath {
    public int solution(int[][] maps) {
        int[] enemy = new int[]{maps[0].length-1, maps.length-1};
        int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        
        boolean[][] visited = new boolean[enemy[1]+1][enemy[0]+1];
        int[][] dist = new int[enemy[1]+1][enemy[0]+1];
        visited[0][0] = true; dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            for(int[] dir : directions){
                int[] next = new int[]{now[0]+dir[0], now[1]+dir[1]};
                
                if(next[0] > enemy[0] || next[0] < 0 || next[1] > enemy[1] || next[1] < 0)
                    continue;
                else if(maps[next[1]][next[0]] == 0)
                    continue;
                
                if(!visited[next[1]][next[0]]){
                    dist[next[1]][next[0]] = dist[now[1]][now[0]] + 1;
                    visited[next[1]][next[0]] = true;
                    queue.add(next);
                }
            }
        }
        
        if (dist[enemy[1]][enemy[0]] != 0)
            return dist[enemy[1]][enemy[0]];
        else
            return -1;
    }

    public static void main(String[] args) {
        P37_1844_ShortestMapPath p = new P37_1844_ShortestMapPath();
        System.out.println(p.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}})); // 11
        System.out.println(p.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}})); // -1
    }
}