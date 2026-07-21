class Solution {
    public int solution(int n, int a, int b) // 8, 4, 7
    {
        // 1 2 3 4 5 6 7 8
        // 1 1 2 2 3 3 4 4
        // 1 1 1 1 2 2 2 2

        int round = 0;
        while (n > 1) {
            round++;

            int[] parent = new int[n + 1];

            for (int i = 1; i < n + 1; i++) {
                parent[i] = (i + 1) / 2;
            }

            if (parent[a] == parent[b])
                break;

            a = (a + 1) / 2;
            b = (b + 1) / 2;
            n = n / 2; // 4, 2

        }
        return round; // 3
    }
}