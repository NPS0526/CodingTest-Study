import java.util.*;

class Solution {

    private static int[] visited;
    private static int[][] globalComputers;
    private static int N;

    public void dfs(int now) {
        visited[now] = 1;

        for (int i = 0; i < N; i++) {
            if (globalComputers[now][i] == 1 && visited[i] == 0)
                dfs(i);
        }
    }


    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        globalComputers = computers;
        N = n;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
}
