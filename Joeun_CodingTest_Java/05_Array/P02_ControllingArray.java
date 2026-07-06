import java.util.*;
public class P02_ControllingArray {
    public static int[] solution(int[] arr) {
        /* for 문 사용
        arr = Arrays.stream(arr).distinct().sorted().toArray();
        
        for (int i=0; i<arr.length/2; i++){
            int tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        } */

        // Collections.reverseOrder() 사용
        arr = Arrays.stream(arr).distinct().boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1};
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }
}