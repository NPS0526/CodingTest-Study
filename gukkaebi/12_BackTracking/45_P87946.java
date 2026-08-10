class Solution {
    private static int[] visited;
    private static int[][] Dungeons;
    private static int answer;


    public void dfs(int stamina, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            if (visited[i] == 0 && stamina >= Dungeons[i][0]) {
                visited[i] = 1;
                answer = Math.max(answer, cnt + 1);
                dfs(stamina - Dungeons[i][1], cnt + 1);
                visited[i] = 0;
            }
        }
    }


    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        Dungeons = dungeons;
        answer = -1;

        dfs(k, 0);

        return answer;
    }
}