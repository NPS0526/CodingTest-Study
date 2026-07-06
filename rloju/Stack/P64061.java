package Stack;

import java.util.ArrayDeque;

public class P64061 {
    public int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        
        for(int m : moves){
            for (int[] ints : board) {
                if (ints[m - 1] != 0) {
                    int val = ints[m-1];
                    ints[m - 1] = 0;
                    if (!stack.isEmpty() && stack.peek() == val) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(val);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
