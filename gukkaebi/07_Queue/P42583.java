import java.util.*;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		// bridge_length: 2 (다리에 올라갈 수 있는 트럭 수)
		// weight: 2 (다리가 견딜 수 있는 무게)
		// truck_weights: [7,4,5,6] (트럭 별 무게)

		// int answer = 0;
		// return answer; // 8 (모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 출력)

		// bridge 큐에 다리를 건너는 트럭 저장
		// while 문 돌려서 현재 다리에 있는 트럭 전체 무게와 현재 대기 트럭에서 들어갈 트럭 무게 합한게 weight보다 같거나 작으면
		// bridge큐에 추가
		// 만약 크면?? 그러면 그냥 0을 bridge 큐에 add 해
		// bridge의 크기가 bridge_length보다 bridge에서 pop() 수행 그리고 land 큐에 add
		// 그러면 다리를 지난 트럭 큐를 생성해야 하네 -> land 큐 생성
		// 종료 조건 : land 큐가 맨 처음 대기 트럭 사이즈와 같으면 종료

		ArrayDeque<Integer> bridge = new ArrayDeque<>();
		ArrayDeque<Integer> land = new ArrayDeque<>();

		int n = truck_weights.length;

		// bridge 배열 초기화
		for (int k = 0; k < bridge_length; k++) {
			bridge.add(0);
		}

		int time = 0;
		int i = 0;
		int curr_weights = 0;
		while (land.size() < n) {
			time++;

			int target = bridge.pop();
			if (target != 0) {
				land.add(target);
				curr_weights -= target;
			}

			if (i < n) {
				if (curr_weights + truck_weights[i] <= weight) {
					bridge.add(truck_weights[i]);
					curr_weights += truck_weights[i];
					i++;
				} else { // 대기 트럭에 있는 트럭이 들어가면 weight를 초과할 경우
					bridge.add(0);
				}
			} else { // 이미 대기 트럭이 다리를 건너고 있는 중일 때 0만 add 해서 시간만 보냄
				bridge.add(0);
			}
		}

		return time;
	}
}