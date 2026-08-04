package Set;

import java.util.*;

public class P1845 {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums) set.add(n);
        
        return Math.min(set.size(), nums.length / 2);
    }
}
