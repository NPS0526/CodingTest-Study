import java.util.*;
import java.util.stream.*;

public class RP71_42583_TruckCrossingBridge { // 다리를 지나는 트럭
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; int sum = 0;
        ArrayDeque<Integer> qTruck = Arrays.stream(truck_weights).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> qBridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++){
            qBridge.addLast(0);
        }
        
        // 트럭 하나씩 꺼내서 다리에 넣기
        while(!qTruck.isEmpty()){
            answer += 1;
            sum -= qBridge.pollFirst();
            if (sum + qTruck.peekFirst() > weight){
                qBridge.addLast(0);
            } else {
                int w = qTruck.pollFirst();
                qBridge.addLast(w);
                sum += w;
            }
        }
        
        // 다리에 남아있는 트럭 지나가는 시간 계산
        while(sum != 0){
            answer += 1;
            sum -= qBridge.pollFirst();
        }
        
        return answer;
    }

    public static void main(String[] args) {
        RP71_42583_TruckCrossingBridge p = new RP71_42583_TruckCrossingBridge();
        System.out.println(p.solution(2, 10, new int[]{7, 4, 5, 6})); // 8
    }
}