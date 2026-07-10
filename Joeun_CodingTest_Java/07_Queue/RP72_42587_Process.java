import java.util.*;

public class RP72_42587_Process { // 다리를 지나는 트럭
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 우선순위 큐 초기화 [우선순위, location]
        ArrayDeque<int[]> qPriorities = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++){
            qPriorities.addLast(new int[]{priorities[i], i});
        }
        // 최댓값 배열 생성 (오름차순 주의)
        int[] max = priorities.clone();
        Arrays.sort(max);
        int iMax = max.length-1;
        
        while (!qPriorities.isEmpty()){
            if (qPriorities.peekFirst()[0] == max[iMax]){ // 큐에서 꺼낼 차례라면
                answer += 1;
                if (qPriorities.pollFirst()[1] == location){ // 꺼낸 작업이 답에 해당하는 작업이면
                    break;
                }
                iMax -= 1;
            } else {
                qPriorities.addLast(qPriorities.pollFirst());
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        RP72_42587_Process p = new RP72_42587_Process();
        System.out.println(p.solution(new int[]{2, 1, 3, 2}, 2)); // 1
    }
}