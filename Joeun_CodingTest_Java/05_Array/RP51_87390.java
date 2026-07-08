import java.util.*;
public class RP51_87390 {
    public static int[] solution(int n, long left, long right) {
        int tmp = (int) right - (int)left+1;
        int[] result = new int[tmp];
        int idx = 0;
        for (long i=left; i<=right; i++){
            long r = i/n; long c = i%n;
            if (r >= c){
                result[idx] = (int) r+1;
            } else {
                result[idx] = (int) c+1;
            }
            idx += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = solution(3, 2, 5);
        System.out.println(Arrays.toString(result));
    }
}