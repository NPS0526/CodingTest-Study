class Solution {
	public int[] solution(int n, long left, long right) {
		int size = (right - left + 1);
		int[] answer = new int[size];

		int idx = 0;

		for (i = left; i < right + 1; i++) {
			row = i % n;
			col = i * n;
			answer[idx++] = Math.max(row, col);
		}
		
		return answer;
	}
}