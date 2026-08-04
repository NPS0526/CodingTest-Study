package Graph;

import java.util.*;

public class P43162 {
    static HashMap<Integer, Boolean> visited = new HashMap<>();
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    
    public int solution(int n, int[][] computers) {
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(computers[i][j]==1){
                    graph.computeIfAbsent(i, k->new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, k->new ArrayList<>()).add(i);
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<n; i++){
            if(!visited.getOrDefault(i, false)){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int cur){
        visited.put(cur, true);
        
        if(graph.containsKey(cur)){
            for(int g : graph.get(cur)){
                if(!visited.getOrDefault(g, false)) dfs(g);
            }
        }
    }

}
