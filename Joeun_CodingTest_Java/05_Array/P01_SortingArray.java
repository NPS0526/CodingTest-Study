import java.util.*;
public class P01_SortingArray {
    public static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1};
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }
}