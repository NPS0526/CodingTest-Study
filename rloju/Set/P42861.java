package Set;

import java.util.*;

public class P42861 {
    private static int[] parent;
    
    private static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y){
        int r1 = find(x);
        int r2 = find(y);
        parent[r2] = r1;
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        int answer = 0;
        int nodeCnt = 1;
        
        for(int i=0; i<n; i++) parent[i] = i;
        
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));
        
        for(int[] cost : costs){
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];
            
            if(find(from) != find(to)){
                union(from, to);
                answer += weight;
                nodeCnt++;
                
                if(nodeCnt == n) break;
            }
        }
        return answer;
    }
}
