package Stack;

import java.util.ArrayDeque;

public class P42584 {
    public int[] solution(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int len = prices.length;
        int[] answer = new int[len];
        
        stack.push(0);
        for(int i=1; i<len; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = len - 1 - idx;
        }
        return answer;
    }

}
