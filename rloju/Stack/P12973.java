package Stack;

import java.util.ArrayDeque;

public class P12973 {
    public int solution(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || c != stack.peek()) stack.push(c);
            else{
                stack.pop();
            }
        }
        //if(stack.isEmpty()) return 1;
        //else return 0;
        return stack.isEmpty() ? 1 : 0;
    }
}
