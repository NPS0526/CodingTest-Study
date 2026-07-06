package Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int val = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) val+=1;
            
            deque.addLast(val);
        }
        
        int standard = deque.removeFirst();
        int cnt=1;
        while(!deque.isEmpty()){
            int cur = deque.peekFirst();
            if(standard >= cur){
                deque.pollFirst();
                cnt++;
            }else{
                answer.add(cnt);
                standard = deque.pollFirst();
                cnt=1;
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
