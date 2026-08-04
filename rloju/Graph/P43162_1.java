package Graph;

public class P43162_1 {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int cur, int n, int[][] computers) {
        visited[cur] = true;
        
        for (int next = 0; next < n; next++) {
            if (computers[cur][next] == 1 && !visited[next]) {
                dfs(next, n, computers);
            }
        }
    }
}
