package BackTracking;

import java.util.*;

public class P92342 {
    private static int[] Info;
    private static int bestDiff;
    private static int[] bestAnswer;
    
    private static int calcDiff(int[] candidate){
        int ryanScore = 0;
        int apeachScore = 0;
        
        for(int i=0; i<11; i++){
            int score = 10-i;
            if(candidate[i] == 0 && Info[i] == 0) continue;
            else if(candidate[i] > Info[i]) ryanScore += score;
            else apeachScore += score;
        }
        return ryanScore - apeachScore;
    }
    
    
    private static boolean isBetter(int[] candidate, int[] best){
        for(int i=10; i>=0; i--){
            if(candidate[i] != best[i]) return candidate[i] > best[i];
        }
        return false;
    }
    
    private static void backtrack(int idx, int remain, int[] ryan){
        if(idx==11){
            int[] candidate = ryan.clone();
            candidate[10] += remain;
            
            int diff = calcDiff(candidate);
            
            if(diff>0){
                if(bestAnswer==null || diff > bestDiff || (diff==bestDiff && isBetter(candidate, bestAnswer))){
                    bestDiff = diff;
                    bestAnswer = candidate;
                }
            }
            return;
        }
        
        int need = Info[idx] + 1;
        if(need <= remain){
            ryan[idx] = need;
            backtrack(idx+1, remain - need, ryan);
            ryan[idx] = 0;
        }
        backtrack(idx+1, remain, ryan);
    }
    
    public int[] solution(int n, int[] info) {
        Info = info;
        bestDiff = 0;
        bestAnswer = null;
        
        backtrack(0, n, new int[11]);
        
        if(bestAnswer == null) return new int[]{-1};
        return bestAnswer;
    }
}
