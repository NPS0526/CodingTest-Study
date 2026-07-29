
import java.util.*;

public class P33_42861_ConnectIsland {
    private static class Edge{
        int src;
        int dest;
        int cost;
        
        public Edge(int src, int dest, int cost){
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    private static int[] set;
    
    public int solution(int n, int[][] costs) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        for (int[] edge : costs){
            pq.add(new Edge(edge[0],edge[1],edge[2]));
        }
        
        // 집합 나타내는 배열
        set = new int[n];
        for (int i = 0; i < n; i++){
            set[i] = i;
        }
        
        int answer = 0;
        
        while (!pq.isEmpty()){
            Edge e = pq.poll();
            int r1 = find(e.src);
            int r2 = find(e.dest);
            
            if (r1 != r2){
                answer += e.cost;
                union(e.src, e.dest);
            }
        }
        
        return answer;
    }
    
    private static int find(int n){
        if (set[n] == n){
            return n;
        }
        
        return set[n] = find(set[n]);
    }
    
    private static void union(int x, int y){
        int rx = find(x);
        int ry = find(y);
        set[rx] = ry;
    }

    public static void main(String[] args) {
        P33_42861_ConnectIsland p = new P33_42861_ConnectIsland();
        int answer = p.solution(4,
            new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
        System.out.println(answer); // 4
    }
}