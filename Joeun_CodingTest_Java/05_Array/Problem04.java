import java.util.*;
public class Problem04 {
    public static int[] solution(int[] answers) {
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        int[][] num = {num1, num2, num3};
        int[] idx = new int[3];
        int[] score = new int[3];
            
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<3; j++){
                if (answers[i] == num[j][idx[j]]){
                    score[j] += 1;
                }  
                idx[j] += 1;
                if (idx[j] == num[j].length){
                    idx[j] = 0;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int max = 0;
        for(int i=0; i<3; i++){
            if(score[i]>max){
                max = score[i];
            }
        }
        for(int i=0; i<3; i++){
            if(score[i]==max){
                result.add(i+1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        int[] result = solution(answers);
        System.out.println(Arrays.toString(result));
    }
}