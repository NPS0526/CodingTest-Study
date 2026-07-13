import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // String answer = "";
        // return answer;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            hashMap.put(participant[i], hashMap.getOrDefault(participant[i], 0) + 1);
        }

        for (int j = 0; j < completion.length; j++) {
            hashMap.put(completion[j], hashMap.getOrDefault(completion[j], 0) - 1);

        }

        for (int k = 0; k < participant.length; k++) {
            if (hashMap.get(participant[k]) != 0) {
                return participant[k];
            }
        }

        return "";
    }
}