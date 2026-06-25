import java.util.*;
public class Problem06 {
    public static int[] solution(int N, int[] stages) {
        int max_stage = Arrays.stream(stages).max().getAsInt();
        
        int[] not_clear = new int[max_stage];
        int[] clear = new int[max_stage];
        
        for (int i=0; i<stages.length; i++){
            not_clear[stages[i]] += 1;
            for (int j=1; j<stages[i]; j++){
                clear[j] += 1;
            }
        }
        
        int result[][] = new int[max_stage][max_stage];
        for (int i=0; i<max_stage; i++){
            if(clear[i] != 0){
                result[i] = new int[]{i, not_clear[i]/clear[i]};
            } else {
                result[i] = new int[]{i, 0};
            }
        }
        Arrays.sort(result, (a, b) -> Integer.compare(b[1], a[1]));
        
        return result[0];
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution(N, stages);
        System.out.println(Arrays.toString(result));
    }
}