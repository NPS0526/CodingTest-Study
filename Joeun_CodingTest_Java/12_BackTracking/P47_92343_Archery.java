import java.util.*;

public class P47_92343_Archery {
    
    private static int N;
    private static int[] infoApeach;
    private static int[] infoRian;
    private static int ans;
    private static int[] ansInfo;
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        N = n;
        infoApeach = info;
        infoRian = new int[11];
        ans = -1;
        ansInfo = new int[11];
        
        shootRian(0);
        
        if (ans == -1)
            answer = new int[]{-1};
        else
            answer = ansInfo;
        
        return answer;
    }
    
    private void shootRian(int idx){
        for (int i = N; i >= 0; i--){
            infoRian[idx] = i;
            
            if (Arrays.stream(infoRian).sum() > N)
                continue;
            else if(Arrays.stream(infoRian).sum() == N){
                
                int score = calScore();
                if (score == 0)
                    continue;
                if (ans < score){
                    ans = score;
                    ansInfo = infoRian.clone();
                }
                else if (ans == score){
                    ansInfo = getAns(ansInfo, infoRian.clone());
                }
                continue;
            }
            
            if (idx == 10)
                continue;
            
            shootRian(idx+1);
        }
    }
    
    private int calScore(){
        int apeach = 0; int rian = 0;
        for (int i = 0; i < 11; i++){
            if (infoApeach[i] == 0 && infoRian[i] == 0)
                continue;
            else if (infoApeach[i] >= infoRian[i])
                apeach += (10 - i);
            else
                rian += (10 - i);
        }
        
        return rian - apeach;
    }
    
    private int[] getAns(int[] a, int[] b){
        for (int i = 10; i >= 0; i--){
            if (a[i] < b[i])
                return b;
            else if (a[i] > b[i])
                return a;
        }
        return a;
    }
    public static void main(String[] args) {
        P47_92343_Archery p = new P47_92343_Archery();
        System.out.println(Arrays.toString(p.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0}))); // [0,2,2,0,1,0,0,0,0,0,0]
    }
}