package BackTracking;

public class P12952 {
    private static int[] col;
    private static int N;
    private static int answer;
    
    private static void backtrack(int row){
        if(row == N){
            answer++;
            return;
        }
        
        for(int i=0; i<N; i++){
            boolean flag = true;
            
            for(int j=0; j<row; j++){
                if(col[j]==i || Math.abs(col[j]-i) == Math.abs(j-row)) flag = false;
            }
            if(flag){
                col[row] = i;
                backtrack(row+1);
            }
        }
    }
    
    public int solution(int n) {
        col = new int[n];
        N = n;
        
        answer = 0;
        backtrack(0);
        return answer;
    }
}
