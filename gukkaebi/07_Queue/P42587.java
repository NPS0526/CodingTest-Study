import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> prior_queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(i);
            prior_queue.add(priorities[i]);
        }

        int cnt = 0;
        while (true) {
            int curr_idx = queue.pop();
            int curr_priority = prior_queue.pop();

            boolean flag = true;
            for (int priority : prior_queue) {
                if (curr_priority < priority) {
                    flag = false;
                    queue.add(curr_idx);
                    prior_queue.add(curr_priority);
                    break;
                }
            }

            if (flag == true)
                cnt++;

            if (flag == true && curr_idx == location) {
                break;
            }
        }

        return cnt;
    }
}