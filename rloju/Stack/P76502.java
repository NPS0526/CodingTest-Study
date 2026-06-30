package Stack;

import java.util.ArrayDeque;

public class P76502 {
    public int solution(String s) {
        int list_len = s.length();
        s += s;
        int cnt = 0;
        
        for(int i=0; i<list_len; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean valid = true;
            
            for(int j=i; j<i+list_len; j++){
                char c = s.charAt(j); // charAt : 문자열, 지정된 인덱스 위치의 문자를 반환
                
                if(c=='(' || c=='[' || c=='{') stack.push(c);
                else{
                    if(stack.isEmpty()) {valid = false; break;}
                    char top = stack.pop();
                    if(c==')' && top!='(') {valid = false; break;}
                    if(c==']' && top!='[') {valid = false; break;};
                    if(c=='}' && top!='{') {valid = false; break;}
                }
            }
            if(valid && stack.isEmpty()) cnt++;
        }
        return cnt;
    }
}
