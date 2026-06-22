import java.util.*;
public class Problem03 {
    public static int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                list.add(numbers[i]+numbers[j]);
            }
        }
        list.sort(null);
        ArrayList<Integer> list_ans = new ArrayList<>();
        list_ans.add(list.get(0));
        for (int i=1; i<list.size(); i++){
            if (!list.get(i-1).equals(list.get(i))){
                list_ans.add(list.get(i));
            }
        }
        return list_ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }
}