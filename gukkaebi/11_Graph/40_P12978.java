import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {

        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i <= N; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : road) {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDest = current[0];
            int currCost = current[1];

            // 최적화(없어도 되긴 함)
            if (dist[currDest] < currCost)
                continue;

            for (int[] next :
                    adjList.get(currDest)) {
                int nextDest = next[0];
                int nextCost = next[1] + currCost;

                if (dist[nextDest] > nextCost) {
                    dist[nextDest] = nextCost;
                    pq.offer(new int[]{nextDest, nextCost});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++)
            if (dist[i] <= K)
                answer++;
        return answer;
    }
}