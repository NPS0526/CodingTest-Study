class Solution {
    private static int N;
    private static int[] board;
    private static int answer;

    public void dfs(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col;

            if (isValid(row))
                dfs(row + 1);
        }
    }

    public boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i])
                return false;

            // 대각선에 있는 경우 (행의 차이 = 열의 차이)
            if (Math.abs(row - i) == Math.abs(board[row] - board[i]))
                return false;
        }

        return true;
    }

    public int solution(int n) {
        answer = 0;
        board = new int[n];
        N = n;

        dfs(0);
        return answer;
    }
}