class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
//        int[][] answer = {};
//        return answer;

		int r1 = arr1.length;
		int c1 = arr1[0].length;

		int r2 = arr2.length;
		int c2 = arr2[0].length;

//    	정상적인 행렬 입력이라 함은, c1==r2가 같게 나온다는 의미

		int[][] answer = new int[r1][c2];
		for (int r = 0; r < r1; r++) {
			for (int c = 0; c < c2; c++) {
				for (int k = 0; k < c1; k++) {
					answer[r][c] += arr1[r][k] * arr2[k][c];
				}
			}
		}
		return answer;
	}
}