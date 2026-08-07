import java.util.*;

class Solution {

    private static class Node {
        int r, c, dir, cost;

        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    }

    // 상우하좌(시계방향)
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public int solution(int[][] board) {

        int n = board.length;

        // visited[r][c][dir] : (r,c) 좌표에서 특정 방향으로 도달했을 때의 최소 비용
        int[][][] visited = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(0, 0, -1, 0));

        int minCost = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.r == n - 1 && current.c == n - 1) {
                minCost = Math.min(minCost, current.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;

                if (board[nr][nc] == 1)
                    continue;

                int nextCost = current.cost;

                // 처음 출발하는 경우 또는 방향이 그대로인 경우
                if (current.dir == -1 || current.dir == i)
                    nextCost += 100;

                // 수직에서 수평 또는 수평에서 수직으로 방향이 꺽인 경우
                else if (current.dir % 2 != i % 2)
                    nextCost += 600;

                // 상에서 하 또는 좌에서 우로 유턴하는 경우
                else
                    nextCost += 100;

                if (nextCost <= visited[nr][nc][i]) {
                    visited[nr][nc][i] = nextCost;
                    queue.offer(new Node(nr, nc, i, nextCost));
                }
            }
        }
        return minCost;
    }
}