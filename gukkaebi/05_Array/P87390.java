class Solution {
	public int[] solution(int n, long left, long right) {
		int size = (int) (right - left + 1);
		int[] answer = new int[size];

		int idx = 0;

		for (long i = left; i < right + 1; i++) {
//			이 부분 이해 잘 안됨
			long row = i / n;
			long col = i % n;
			answer[idx++] = (int) Math.max(row, col) + 1;
		}

		return answer;
	}
}