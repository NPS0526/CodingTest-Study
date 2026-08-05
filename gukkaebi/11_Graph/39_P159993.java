import java.util.*;

class Solution {

    static char[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n, m;

    public int solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];

        int startR = 0, startC = 0;
        int leverR = 0, leverC = 0;

        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                } else if (map[i][j] == 'L') {
                    leverR = i;
                    leverC = j;
                }
            }
        }

        int toLever = bfs(startR, startC, 'L');
        if (toLever == -1)
            return -1;

        int toExit = bfs(leverR, leverC, 'E');
        if (toExit == -1)
            return -1;

        return toLever + toExit;
    }

    static int bfs(int R, int C, char target) {
        Queue<int[]> queue = new ArrayDeque<>();

        int[][] visited = new int[n][m];

        queue.offer(new int[]{R, C, 0});
        visited[R][C] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currR = current[0];
            int currC = current[1];
            int currDist = current[2];

            if (map[currR][currC] == target)
                return currDist;

            for (int i = 0; i < 4; i++) {
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m)
                    continue;

                if (visited[nr][nc] != 0)
                    continue;

                if (map[nr][nc] != 'X') {
                    visited[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc, currDist + 1});
                }
            }
        }
        return -1;
    }
}