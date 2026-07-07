package Queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class P159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        //Arrays.asList()를 Deque 생성자에 바로 주입
        ArrayDeque<String> card1_deque = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> card2_deque = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goal_deque = new ArrayDeque<>(Arrays.asList(goal));
        
        //for(int i=0; i<cards1.length; i++) card1_deque.addLast(cards1[i]);
        //for(int i=0; i<cards2.length; i++) card2_deque.addLast(cards2[i]);
        //for(int i=0; i<goal.length; i++) goal_deque.addLast(goal[i]);
        
        
        while(!goal_deque.isEmpty()){
            if(!card1_deque.isEmpty() && card1_deque.peekFirst().equals(goal_deque.peekFirst())){
                card1_deque.pollFirst();
                goal_deque.pollFirst();
            }else if(!card2_deque.isEmpty() && card2_deque.peekFirst().equals(goal_deque.peekFirst())){
                card2_deque.pollFirst();
                goal_deque.pollFirst();
            }else break;
        }
        
        return goal_deque.isEmpty() ? "Yes" : "No";
    }
}


