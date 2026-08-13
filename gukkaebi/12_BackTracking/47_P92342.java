class Solution {

    private int[] answer;
    private int N;
    private int max;
    private int[] apeach;
    private int diff;

    public int getScoreDiff(int[] lion) {
        int diff = 0;

        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && lion[i] == 0) {
                continue;
            }
            if (apeach[i] >= lion[i]) {
                diff -= 10 - i;
            } else if (apeach[i] < lion[i]) {
                diff += 10 - i;
            }
        }

        return diff;
    }

    public void getMax(int[] lion) {
        int diff = getScoreDiff(lion);

        if (diff <= 0)
            return;

        if (max < diff) {
            max = diff;
            answer = lion.clone();
        } else if (max == diff) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] < lion[i]) {
                    answer = lion.clone();
                    break;
                } else if (answer[i] > lion[i]) {
                    break;
                }
            }

        }

        return;
    }

    public void combination(int arrow, int idx, int[] lion) {
        if (arrow == 0 || idx == 10) {
            lion[10] = arrow;
            getMax(lion);
            lion[10] = 0;
            return;
        }


        if (apeach[idx] < arrow) {
            int cnt = apeach[idx] + 1;
            lion[idx] = cnt;
            combination(arrow - cnt, idx + 1, lion);
            lion[idx] = 0;
        }


        combination(arrow, idx + 1, lion);
    }

    public int[] solution(int n, int[] info) {
        answer = new int[]{-1};
        N = n;
        max = 0;
        apeach = info.clone();
        diff = 0;
        combination(n, 0, new int[11]);
        return answer;
    }
}