import java.util.*;

class Solution {
	public int[] solution(int[] prices) {
		int n = prices.length;
		int[] answer = new int[n];

		Stack<Integer> stack = new Stack<>();
		stack.push(0); // 스택에는 인덱스를 저장
		int curr_idx = 0;

		for (int i = 0; i < n; i++) {
			// 스택에 [0(5), 1(4), 2(3)]
			// i=3일 때, 가격이 2라면 이전 3개의 값들을 여기서 떨어진 것으로 확정해야 하기 때문에 while문 사용
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int j = stack.pop();
				answer[j] = i - j;
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int k = stack.pop();
			answer[k] = n - 1 - k;
		}

		return answer;

	}
}