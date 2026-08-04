public class P38_43162_Network_DFS {
    private static int[][] computer;
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        computer = computers;
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int now){
        visited[now] = true;
        
        for(int i = 0; i < computer[now].length; i++){
            if (visited[i] == false && computer[now][i] == 1)
                dfs(i);
        }
    }

    public static void main(String[] args) {
        P38_43162_Network_DFS p = new P38_43162_Network_DFS();
        System.out.println(p.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
        System.out.println(p.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1
    }
}