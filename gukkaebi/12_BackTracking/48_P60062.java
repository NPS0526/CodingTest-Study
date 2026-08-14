class Solution {
    private static int[] expandWeak;
    private static int[] Dist;
    private static int answer;

    public void backtrack(int cnt, boolean[] visited, int[] friendOrder, int weakLen) {
        if (cnt == Dist.length) {
            for (int start = 0; start < weakLen; start++) {

                int friendIdx = 0;
                int position = expandWeak[start] + friendOrder[friendIdx];

                boolean possible = true;
                for (int i = start; i < start + weakLen; i++) {
                    if (position < expandWeak[i]) {
                        friendIdx++;

                        if (friendIdx == friendOrder.length) {
                            possible = false;
                            break;
                        }
                        position = expandWeak[i] + friendOrder[friendIdx];

                    }
                }
                if (possible) {
                    answer = Math.min(answer, friendIdx + 1);

                }
            }


            return;
        }

        for (int i = 0; i < Dist.length; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            friendOrder[cnt] = Dist[i];
            backtrack(cnt + 1, visited, friendOrder, weakLen);
            visited[i] = false;
        }
    }


    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        expandWeak = new int[len * 2];
        Dist = dist;
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            expandWeak[i] = weak[i];
            expandWeak[i + len] = weak[i] + n;
        }

        boolean[] visited = new boolean[dist.length];
        int[] friendOrder = new int[dist.length];

        backtrack(0, visited, friendOrder, len);

        return answer == Integer.MAX_VALUE ? -1 : answer;


    }
}