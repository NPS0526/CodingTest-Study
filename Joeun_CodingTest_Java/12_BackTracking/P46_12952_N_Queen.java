import java.util.*;

public class P46_12952_N_Queen {
    private static int answer;
    private static int N;
    private static int[] visited;
    
    public int solution(int n) {
        answer = 0;
        N = n;
        visited = new int[n]; // index: 퀸의 열, value: 퀸의 행
        Arrays.fill(visited, -1);
        nQueen(0); // 각 행마다 퀸 놓을 수 있는지 체크
        
        return answer;
    }
    
    private void nQueen(int r){
        for (int c = 0; c < N; c++){
            if (visited[c] == -1){ // 퀸이 없는 열이면
                boolean flag = true;
                
                // 퀸의 대각선인지 체크
                for (int i = 0; i < N; i++){
                    if (visited[i] != -1){ // 각 퀸에 대해
                        if (Math.abs(visited[i]-r) ==
                           Math.abs(i-c)){
                            flag = false;
                            break;
                        }
                    }
                }
                
                if (flag){
                    visited[c] = r;
                    if (r == N-1)
                        answer++;
                    else {
                        nQueen(r+1);
                    }
                    visited[c] = -1;
                }
            }
        }
    }
    public static void main(String[] args) {
        P46_12952_N_Queen p = new P46_12952_N_Queen();
        System.out.println(p.solution(4)); // 2
    }
}