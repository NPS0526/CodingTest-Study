import java.util.*;

class Solution {
    static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        if (find(x) != find(y)) {
            parent[find(y)] = find(x);
        }
    }

    public int solution(int n, int[][] costs) {
        // int answer = 0;
        // return answer;

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int cnt = 0;

        for (int[] cost : costs) {

            if (cnt == n - 1) {
                return totalCost;
            }

            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                cnt++;
                totalCost += cost[2];
            }
        }

        return totalCost;
    }
}