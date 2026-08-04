import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // int answer = 0;
        // return answer;

        int n = nums.length;
        int k = n / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), k);
    }
}