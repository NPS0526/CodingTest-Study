import java.util.*;
public class P11_12973 {
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (stack.isEmpty()){
                stack.push(c);
            } else {
                char st = stack.pop();
                if (st == c) {
                    continue;
                } else {
                    stack.push(st);
                    stack.push(c);
                }
            }
        }
        
        if (stack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        P11_12973 p = new P11_12973();
        System.out.println(p.solution("baabaa")); // 1
        System.out.println(p.solution("cdcd")); // 0
    }
}