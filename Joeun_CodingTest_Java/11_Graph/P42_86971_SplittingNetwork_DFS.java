import java.util.*;

public class P42_86971_SplittingNetwork_DFS {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int answer;
    private static int N;
    
    public int solution(int n, int[][] wires) {
        // 인접 리스트
        adjList = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++)
            adjList[i] = new ArrayList<>();
        for (int[] wire : wires){
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        visited = new boolean[n+1];
        answer = Integer.MAX_VALUE;
        N = n;
        
        dfs(1);
        
        return answer;
    }
    
    private static int dfs(int now){
        visited[now] = true;
        
        int sum = 0;
        for (int adj : adjList[now]){
            if(!visited[adj]){
                int cnt = dfs(adj);
                answer = Math.min(answer, Math.abs(N - 2*cnt));
                sum += cnt;
            }
        }
        
        return sum + 1;
    }
    public static void main(String[] args) {
        P42_86971_SplittingNetwork_DFS p = new P42_86971_SplittingNetwork_DFS();
        System.out.println(p.solution(9, 
            new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); // 3
    }
}