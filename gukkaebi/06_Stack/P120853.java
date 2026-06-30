import java.util.*;

class Solution {
	public int solution(String s) {
		String[] arr = s.trim().split("\\s+");
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (String c : arr) {
			if (c.equals("Z")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(Integer.parseInt(c));
			}
		}

		int total = 0;
		if (!stack.isEmpty()) {
			for (int num : stack) {
				total += num;
			}
		}

		return total;

	}
}