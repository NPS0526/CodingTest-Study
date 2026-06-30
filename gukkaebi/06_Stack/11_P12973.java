import java.util.*;

class Solution {
	public int solution(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();

		int n = s.length();

		for (int i = 0; i < n; i++) {
			char curr_s = s.charAt(i);

			if (!stack.isEmpty() && stack.peekFirst() == curr_s) {
				stack.pop();
			} else {
				stack.push(curr_s);
			}
		}

		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}
}