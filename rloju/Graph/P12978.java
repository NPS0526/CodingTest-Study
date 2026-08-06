package Graph;

import java.util.*;

public class P12978 {
    public int solution(int N, int[][] road, int K) {
        ArrayList<int[]>[] adjList = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) adjList[i] = new ArrayList<>();
        
        for(int[] r : road){
            adjList[r[0]].add(new int[]{r[1], r[2]});
            adjList[r[1]].add(new int[]{r[0], r[2]});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{1, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            if(dist[cur[0]] < cur[1]) continue;
            
            for(int[] next : adjList[cur[0]]){
                if(dist[next[0]] > cur[1] + next[1]){
                    dist[next[0]] = cur[1] + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        
        int answer = 0;
        for(int d : dist){
            if(d<=K) answer++;
        }
        return answer;
    }

}
