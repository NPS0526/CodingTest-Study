import java.util.*;

public class P41_67259_RaceTrack {
    private static class Node{
        int x;
        int y;
        int cost;
        int dir;
        
        public Node(int x, int y, int cost, int dir){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
    
    public int solution(int[][] board) {
        int N = board.length;
        // 상, 좌, 하, 우
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        int[][][] dist = new int[N][N][4];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        Arrays.fill(dist[0][0], 0);
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0,0,-1));
        int answer = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()){
            Node now = queue.poll();
            
            for (int i = 0; i < 4; i++){
                int xNext = now.x + dx[i];
                int yNext = now.y + dy[i];
                
                if (xNext < 0 || xNext >= N ||
                   yNext < 0 || yNext >= N)
                    continue;
                
                if (board[yNext][xNext] == 1)
                    continue;
                
                int costNext = now.cost;
                if (now.dir == -1 ||
                   (now.dir - i) % 2 == 0)
                    costNext += 100;
                else
                    costNext += 600;
                
                if (dist[yNext][xNext][i] > costNext){
                    dist[yNext][xNext][i] = costNext;
                    queue.add(new Node(xNext, yNext, costNext, i));
                    if (xNext == N-1 && yNext == N-1)
                        answer = Math.min(answer, costNext);
                }
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        P41_67259_RaceTrack p = new P41_67259_RaceTrack();
        System.out.println(p.solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}})); // 3200
    }
}