import java.util.*;


class Solution {

    private static int[] visited;
    private static List<Integer>[] adjList;
    private static int answer;

    public int solution(int n, int[][] wires) {

        adjList = new ArrayList[n + 1];
        visited = new int[n + 1];
        answer = n - 1;

        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge :
                wires) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }


        dfs(1, n);

        return answer;
    }

    public int dfs(int node, int n) {
        visited[node] = 1;

        int sum = 0;
        for (int next :
                adjList[node]) {

            if (visited[next] == 0) {
                int cnt = dfs(next, n);
                answer = Math.min(answer, Math.abs(2 * cnt - n));
                sum += cnt;
            }
        }
        return sum + 1;
    }


}