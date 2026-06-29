import java.util.*;
public class P08_12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else{
                if (stack.isEmpty()){
                    answer = false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        P08_12909 p = new P08_12909();
        System.out.println(p.solution("()()")); // true
        System.out.println(p.solution("(())")); // true
        System.out.println(p.solution("(()")); // false
    }
}