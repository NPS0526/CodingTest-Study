package Graph;

import java.util.*;

public class P86971 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int answer, n;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] w : wires) {
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        visited = new boolean[n + 1];
        dfs(1);
        
        return answer;
    }
    
    private int dfs(int cur) {
        visited[cur] = true;
        int count = 1;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                int childCount = dfs(next);
                answer = Math.min(answer, Math.abs(n - 2 * childCount));
                count += childCount;
            }
        }
        return count;
    }
}
