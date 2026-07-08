import java.util.*;

class Solution {
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		// cards1: ["i", "drink", "water"]
		// cards2: ["want", "to"]
		// goal: ["i", "want", "to", "drink", "water"]

		// String answer = "";
		// return answer; // "Yes"

		// 우선은 card1과 card2의 첫번째 요소들 중에 비교하여 goal의 첫번째 요소와 같으면 queue에 add
		// add 한 다음에 card 요소에서 지우고
		// 계속 똑같이 이렇게 비교하면 되네

		ArrayDeque<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
		ArrayDeque<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));

		String answer = "No";
		int n = goal.length;

		int i = 0;
		boolean flag = true;
		while (i < n) {
			if (goal[i].equals(queue1.peek())) {
				queue1.pop();
				i++;
			} else if (goal[i].equals(queue2.peek())) {
				queue2.pop();
				i++;
			} else {
				flag = false;
				break;
			}
		}

		if (flag) {
			answer = "Yes";
		}

		return answer;
	}
}