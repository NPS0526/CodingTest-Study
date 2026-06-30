import java.util.*;
public class P09_76502 {
    public int solution(String s) {
        int answer = 0;
        String str = "()[]{}";
        for (int i = 0; i < s.length(); i++){
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == '(' || s.charAt(j) == '{' || s.charAt(j) == '['){
                    stack.push(s.charAt(j));
                } else {
                    if (stack.isEmpty()){
                        flag = false;
                        break;
                    } else{
                        char c = stack.pop();
                        if (c != str.charAt(str.indexOf(s.charAt(j))-1)){
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (!stack.isEmpty()){
                flag = false;
            }
            
            if (flag){
                answer += 1;
            }
            s = s.substring(1,s.length()) + s.charAt(0);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        P09_76502 p = new P09_76502();
        System.out.println(p.solution("[](){}")); // 3
        System.out.println(p.solution("(())")); // 1
        System.out.println(p.solution("(()")); // 0
    }
}