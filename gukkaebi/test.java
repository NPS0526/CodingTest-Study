class Solution {
	public int[] solution(int N = 5, int[] stages = {1,2,3,4,5}) {
//        int[] answer = {};
//        return answer;

		int[] challenger = new int[N + 2];
		for (int stage : stages) {
			challenger[stage]++;
			println(challenger[stage]);
			
		}
	}
}