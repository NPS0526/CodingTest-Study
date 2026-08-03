import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        // int[] answer = {};
        // return answer;

        ArrayList<String> usedwords = new ArrayList<>();

        int cnt = 0;
        int idx = 0;
        char keyword = words[0].charAt(0);

        for (String word : words) {

            // cnt++;

            int k = word.length();

            if (usedwords.contains(word)) {
                return new int[]{idx % n + 1, cnt / n + 1};
            }

            if (keyword != word.charAt(0)) {
                return new int[]{idx % n + 1, cnt / n + 1};
            }

            idx++;
            cnt++;
            usedwords.add(word);
            keyword = word.charAt(k - 1);
        }

        return new int[]{0, 0};

    }
}