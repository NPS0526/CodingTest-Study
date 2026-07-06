import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		// progresses : [93, 30, 55]
		// speeds : [1, 30, 5]
		// int[] answer = {};
		// return answer; //[2, 1]

		// 각 speed에 따라, 100이 언제 되는지 먼저 계산하고
		// 차례대로 push [7, 3, 9]
		// 우선 첫번째는 pop하고 peekLast()와 비교하여 peekLast가 더 작으면 pop하고 cnt+=1

		ArrayDeque<Integer> queue = new ArrayDeque<>();

		int n = progresses.length;

		for (int i = 0; i < n; i++) {
			int remain = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0) {
				remain += 1;
			}
			queue.add(remain);
		}
		// System.out.println(queue);

		ArrayList<Integer> list = new ArrayList<>();

		while (!queue.isEmpty()) {
			int curr = queue.pop();
			int cnt = 1;

			while (!queue.isEmpty() && curr >= queue.peekFirst()) {
				queue.pop();
				cnt += 1;
			}
			list.add(cnt);
		}
		// System.out.println(list);

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}