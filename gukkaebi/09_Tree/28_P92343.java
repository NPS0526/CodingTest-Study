import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int[] gInfo;
    static int maxSheep = 0;

    static class State {
        int node;
        int sheep;
        int wolf;
        List<Integer> nextNodes;

        public State(int node, int sheep, int wolf, List<Integer> nextNodes) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.nextNodes = nextNodes;
        }
    }

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        gInfo = info;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            graph[parent].add(child);
        }

        bfs();

        return maxSheep;
    }

    static void bfs() {
        Queue<State> queue = new ArrayDeque<>();

        List<Integer> startNextNodes = new ArrayList<>();
        for (int child : graph[0]) {
            startNextNodes.add(child);
        }

        queue.offer(new State(0, 1, 0, startNextNodes));
        maxSheep = 1;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            maxSheep = Math.max(maxSheep, current.sheep);

            for (int nextNode : current.nextNodes) {
                int sheepCnt = current.sheep;
                int wolfCnt = current.wolf;

                if (gInfo[nextNode] == 0) {
                    sheepCnt++;
                } else {
                    wolfCnt++;
                }

                if (wolfCnt >= sheepCnt)
                    continue;

                List<Integer> nextAvailableNodes = new ArrayList<>(current.nextNodes);

                nextAvailableNodes.remove(Integer.valueOf(nextNode));

                for (int child : graph[nextNode]) {
                    nextAvailableNodes.add(child);
                }

                queue.offer(new State(nextNode, sheepCnt, wolfCnt, nextAvailableNodes));
            }
        }
    }
}