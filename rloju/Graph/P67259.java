package Graph;

import java.util.*;

public class P67259 {
    static class Node {
        int r;
        int c;
        int cost;
        int prevDir;
        
        public Node(int r, int c, int cost, int prevDir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.prevDir = prevDir;
        }
    }
    
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] visited = new int[n][n][4];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        
        Deque<Node> q = new ArrayDeque<>();
        int totalCost = Integer.MAX_VALUE;
        
        q.offer(new Node(0, 0, 0, -1));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.r == n-1 && cur.c == n-1){
                totalCost = Math.min(cur.cost, totalCost);
                continue;
            }
            
            for(int nextDir=0; nextDir<4; nextDir++){
                int nextR = cur.r + dx[nextDir];
                int nextC = cur.c + dy[nextDir];
                
                if(nextR<0 || nextR>=n || nextC<0 || nextC>=n || board[nextR][nextC] == 1) continue;
                
                int cost = cur.cost;
                if(cur.prevDir == -1 || cur.prevDir == nextDir) cost += 100;
                else cost += 600;
                
                if(visited[nextR][nextC][nextDir] > cost){
                    visited[nextR][nextC][nextDir] = cost;
                    q.offer(new Node(nextR, nextC, cost, nextDir));
                }
            }
        }
        return totalCost;
    }

}
