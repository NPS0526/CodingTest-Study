import java.util.*;
public class P12_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++){
            if (stack.isEmpty()){
                stack.push(new int[] {i,prices[i]});
                continue;
            }
            
            if (prices[i] >= stack.peek()[1]){
                stack.push(new int[] {i,prices[i]});
            } else {
                while (prices[i] < stack.peek()[1]){
                    int[] peek = stack.pop();
                    answer[peek[0]] = i - peek[0];
                    if (stack.isEmpty()){
                        break;
                    }
                }
                stack.push(new int[] {i,prices[i]});
            }
        }
        
        while (!stack.isEmpty()) {
            int[] peek = stack.pop();
            answer[peek[0]] = prices.length - peek[0] - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        P12_42584 p = new P12_42584();
        System.out.println(Arrays.toString(p.solution(new int[] {1, 2, 3, 2, 3}))); // [4, 3, 1, 1, 0]
    }
}