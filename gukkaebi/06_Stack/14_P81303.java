import java.util.*;

class Solution {
	public String solution(int n, int k, String[] cmd) {
		// cmd: ["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]
		Stack<Integer> stack = new Stack<>(); // 스택에 "C"된 것을 저장

		int[] prev = new int[n]; // 이전 값 저장
		int[] next = new int[n]; // 다음 값 저장

		// prev, next 배열 초기화
		for (int i = 0; i < n; i++) {
			prev[i] = i - 1;
			next[i] = i + 1;
		}
		next[n - 1] = -1; // 인덱스 n-1 의 다읍 값은 없으므로 -1로 없음 표시

		int curr = k;
		for (String command : cmd) {
			char direction = command.charAt(0);
			switch (direction) {
			case 'U': {
				int step = Integer.parseInt(command.substring(2));
				// 커서가 현재 4일 때, 3번 행이 지워져 있다면 1로 가야 하는데 2로 가는 오류
//				if (curr - step >= 0) {
//					curr -= step;
//				} else {
//					curr = 0;
//				}
				for (int i = 0; i < step; i++) {
					curr = prev[curr];
				}
				break;
			}
			case 'D': {
				int step = Integer.parseInt(command.substring(2)); // D 100 일 수도 있어서 charAt을 사용하면 안되고 substring을 사용해야 함
				for (int i = 0; i < step; i++) {
					curr = next[curr];
				}
				break;
			}
			case 'C': {
				stack.push(curr);

				// 현재 삭제된 커서 값의 이전값과 다음값
				int pre = prev[curr];
				int nxt = next[curr];

				if (pre != -1) {
					// 예를 들어, prev = [-1,0,1,2,3], next = [1,2,3,4,-1] 일 때
					// [0,1,(2),3,4] => 기존 배열에서 2번 행 삭제
					// 2번 행이 삭제됐다면은 pre = 1, nxt = 3
					// next[pre(1)] = next(3)
					// prev[nxt(3)] = pre(1)
					// 바뀐 배열 : prev = [-1,0,1,1,3], next = [1,3,3,4,-1]
					next[pre] = nxt;
				}
				if (nxt != -1) {
					prev[nxt] = pre;
				}
				curr = (nxt != -1) ? nxt : pre;
				break;
			}
			case 'Z': {
				int undo = stack.pop();

				int pre = prev[undo];
				int nxt = next[undo];

				if (pre != -1) {
					next[pre] = undo;
				}
				if (nxt != -1)
					prev[nxt] = undo;
				break;
			}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("O");
		}
		while (!stack.isEmpty()) {
			sb.setCharAt(stack.pop(), 'X');
		}

		String answer = sb.toString();

		return answer;
	}
}