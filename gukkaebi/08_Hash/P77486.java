import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // enroll : ["john", "mary", "edward", "sam", "emily", "jaimie", "tod",
        // "young"].
        // referral : ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
        // seller : ["young", "john", "tod", "emily", "mary"]
        // amount : [12, 4, 2, 5, 10]
        // result : [360, 958, 108, 0, 450, 18, 180, 1080]

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();

        // parentMap 초기화
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String currentPerson = seller[i];
            int currentProfit = amount[i] * 100;

            while (!currentPerson.equals("-") && currentProfit > 0) {
                int profitToParent = currentProfit / 10;
                int myProfit = currentProfit - profitToParent;

                profitMap.put(currentPerson, profitMap.getOrDefault(currentPerson, 0) + myProfit);

                currentPerson = parentMap.get(currentPerson);
                currentProfit = profitToParent;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}