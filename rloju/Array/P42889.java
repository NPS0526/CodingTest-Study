package Array;

import java.util.Arrays;

public class P42889 {
    public int[] solution(int N, int[] stages) {
        int[] challenge = new int[N+2];
        int total = stages.length;
        
        for(int s : stages){
            challenge[s]++;
        }
        // 전체 - 이미 cnt 한 사람
        // 해당 수
        /*HashMap<Integer, Double> fail_prob = new HashMap<>();
        for(int i = 1; i<=N; i++){
            if(challenge[i]==0){
                fail_prob.put(i, 0.0);
            }else{
                fail_prob.put(i, (challenge[i] / total));
                total -= challenge[i];
            }
        }*/
        
        double[] fail_prob = new double[N+1];
        for(int i = 1; i<=N; i++) {
            if (challenge[i] == 0) {
                fail_prob[i] = 0;
            } else {
                fail_prob[i] = (double)(challenge[i] / total);
                total -= challenge[i];
            }
        }
        
        Integer[] answer = new Integer[N];
        for (int i = 0; i < N; i++) answer[i] = i + 1;
        
        Arrays.sort(answer, (a, b) -> Double.compare(fail_prob[b], fail_prob[a]));
        
        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
}
