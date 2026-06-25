package Array;

// n^2 배열 자르기
public class P87380 {
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left;
        int[] answer = new int[len+1];
        
        int idx = 0;
        for (long i = left; i <= right; i++) {
            // 1차원 인덱스 -> 2차원 행, 열
            long row = i / n;
            long col = i % n;
            
            answer[idx++] = Math.max((int)row, (int)col) + 1;
        }
        return answer;
    }
}
