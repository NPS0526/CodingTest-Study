import java.util.*;

public class P31_1845_Ponketmon {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> ponketmon = new HashMap<>();
        for (int num : nums){
            ponketmon.merge(num,1,Integer::sum);
        }
        
        int nType = ponketmon.keySet().size();
        
        if (nType >= nums.length/2){
            return nums.length/2;
        } else {
            return nType;
        }
    }

    public static void main(String[] args) {
        P31_1845_Ponketmon p = new P31_1845_Ponketmon();
        System.out.println(p.solution(new int[] {3,1,2,3})); // 2
    }
}