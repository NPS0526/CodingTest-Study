package Array;
import java.util.HashSet;

public class P68644 {
    public static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] result = solution(numbers);
        for (int r : result) System.out.print(r + " ");
    }
}
