class Solution {
	public int[] solution(int n, long left, long right) {
		// int[] answer = {};
		// return answer;
//		int[][] arr = new int[n][n];

		int num = n * n;
		long[] ilza = new long[num];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ilza[i * n + j] = Math.max(i, j) + 1;
			}
		}

		int size = (int) (right - left + 1);
		int[] answer = new int[size];

		int idx = 0;
		for (long st = left; st < right + 1; st++) {
			answer[idx] = (int) ilza[(int)st];
			idx++
		}

		return answer;
	}
}