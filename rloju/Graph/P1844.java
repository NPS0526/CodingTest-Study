package Graph;

import java.util.*;

public class P1844 {
    public int solution(int[][] maps) {
        Deque<int[]> queue = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        queue.addLast(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while(!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            int curRow = cur[0];
            int curCol = cur[1];
            int curLength = cur[2];
            
            if((curRow==n-1) && (curCol==m-1)){
                return curLength;
            }
            
            for(int[] d : dir){
                int nextRow = curRow + d[0];
                int nextCol = curCol + d[1];
                
                if((nextRow>=0 && nextRow<n) && (nextCol>=0 && nextCol<m)){
                    if((maps[nextRow][nextCol]==1) && !visited[nextRow][nextCol]){
                        queue.addLast(new int[]{nextRow, nextCol, curLength+1});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return -1;
    }

}
