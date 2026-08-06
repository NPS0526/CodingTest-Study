import java.util.*;

public class P40_12978_Delivery {
    private static class Node{
        int dest;
        int w;

        public Node(int dest, int w){
            this.dest = dest;
            this.w = w;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int[] r : road){
            adjList[r[0]].add(new Node(r[1],r[2]));
            adjList[r[1]].add(new Node(r[0],r[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new Node(1,0));
        
        while (!pq.isEmpty()){
            Node now = pq.poll();
            
            if (dist[now.dest] < now.w)
                continue;
            
            for (Node next: adjList[now.dest]){
                if (dist[now.dest] + next.w < dist[next.dest]){
                    dist[next.dest] = dist[now.dest] + next.w;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        
        int answer = 0;
        for (int d : dist)
            if (d <= K) answer++;
        
        return answer;
    }

    public static void main(String[] args) {
        P40_12978_Delivery p = new P40_12978_Delivery();
        System.out.println(p.solution(5, 
            new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 
            3)); // 4
        System.out.println(p.solution(6, 
            new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,6,4},{4,5,3},{5,6,1}}, 
            4)); // 4
    }
}