import java.util.*;
public class P14_81303_TableEditing { // 표 편집
    public String solution(int n, int k, String[] cmd) {
        // LinkedList 정보 담긴 배열 초기화 : 앞뒤로 공간 추가
        int[] prev = new int[n+2];
        int[] next = new int[n+2];
        for (int i = 0; i < n+1; i++){
            prev[i] = i-1;
            next[i] = i+1;
        }
        k += 1;
        
        // 명령어에 따라서 처리
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(String command : cmd){
            //System.out.println(k);
            String[] s_arr = command.split(" ");
            int X = 0;
            if (s_arr.length > 1){
                X = Integer.parseInt(s_arr[1]);
            }
            switch(s_arr[0]){
                case "U":
                    while (X-- > 0) {
                        if (prev[k] != 0){
                            k = prev[k];
                        } else {
                            break;
                        }
                    }
                    break;
                case "D":
                    while (X-- > 0) {
                        if (next[k] != n+1){
                            k = next[k];
                        } else {
                            break;
                        }
                    }
                    break;
                case "C":
                    next[prev[k]] = next[k];
                    prev[next[k]] = prev[k];
                    stack.push(k);
                    if (next[k] == n+1) {
                        k = prev[k];
                    } else {
                        k = next[k];
                    }
                    break;
                case "Z":
                    int z_idx = stack.pop();
                    next[prev[z_idx]] = z_idx;
                    prev[next[z_idx]] = z_idx;
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder("O".repeat(n));
        //System.out.println(stack.size());
        for (int idx : stack){
            //System.out.println(idx);
            sb.setCharAt(idx-1,'X');
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        P14_81303_TableEditing p = new P14_81303_TableEditing();
        System.out.println(p.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"})); // "OOOOXOOO"
    }
}