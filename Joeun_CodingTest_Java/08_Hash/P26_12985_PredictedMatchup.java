import java.util.*;

public class P26_12985_PredictedMatchup { // 베스트 앨범
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        while(true){
            if ((a%2) == 0){ // a가 짝수일 때, a-1과 게임
                if ((a-1) == b){
                    break;
                }
            } else {
                if ((a+1) == b){
                    break;
                }
            }
            
            answer += 1;
            
            a = (a+1)/2;
            b = (b+1)/2;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        P26_12985_PredictedMatchup p = new P26_12985_PredictedMatchup();
        System.out.println(p.solution(8,4,7)); // 3
    }
}