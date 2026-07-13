package Hash;

import java.util.HashMap;

public class P131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wants = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wants.put(want[i], number[i]);
        }
        
        int answer = 0;
        for(int i=0; i<discount.length - 9; i++){
            HashMap<String, Integer> mart = new HashMap<>();
            for(int j=i; j<i+10; j++) mart.put(discount[j], mart.getOrDefault(discount[j], 0) + 1);
            
            if(wants.equals(mart)) answer++;
        }
        return answer;
    }
}
