import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int maxValue = 0;
    static int[] dist;

    public int solution(int n, int[][] edges) {
        // n : 4
        // edges : [[1,2],[2,3],[3,4]]
        // result : 2

        // edges에서 인덱스가 1부터 n개이다 보니 n+1로 선언해주어야 함
        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            graph[parent].add(child);
            graph[child].add(parent);
        }

        dist = new int[n + 1];
        // 일단 1번 노드에서 bfs 1회 돌려서 1번 노드와 가장 먼 노드를 찾는다
        bfs(1);

        int maxCount = 0;
        int farthestNode = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] >= maxValue) {
                maxValue = dist[i];
                farthestNode = i;
            }
        }

        bfs(farthestNode);

        for (int i = 1; i <= n; i++) {
            if (dist[i] >= maxValue) { // maxValue 같아도 갱신해주어야..
                maxValue = dist[i];
                farthestNode = i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxValue) {
                maxCount++;
            }
        }

        if (maxCount > 1)
            return maxValue;

        maxCount = 0;
        bfs(farthestNode);

        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxValue) {
                maxCount++;
            }
        }

        if (maxCount > 1)
            return maxValue;

        return maxValue - 1;
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);

        Arrays.fill(dist, -1);
        dist[startNode] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : graph[currentNode]) {
                if (dist[nextNode] == -1) {
                    dist[nextNode] = dist[currentNode] + 1;
                    queue.offer(nextNode);
                }
            }
        }
    }
}