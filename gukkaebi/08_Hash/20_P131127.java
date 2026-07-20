import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            hashMap.put(want[i], number[i]);
        }

        int st = 0;
        while (st <= discount.length - 10) {
            HashMap<String, Integer> temp = new HashMap<>();
            String[] ten_days = Arrays.copyOfRange(discount, st, st + 10);

            for (int j = 0; j < 10; j++) {
                temp.put(ten_days[j], temp.getOrDefault(ten_days[j], 0) + 1);
            }

            if (hashMap.equals(temp)) {
                answer += 1;
            }

            st++;
        }

        return answer;
    }
}