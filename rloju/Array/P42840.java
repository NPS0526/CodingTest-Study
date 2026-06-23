package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P42840 {
    public static int[] solution(int[] answers){
        
        // 수포자들의 답안 패턴 파악하기
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] score = new int[3];
        
        for (int i=0; i < answers.length; i++){
            for (int j=0; j<pattern.length; j++){
                // 정답길이가 답안패턴의 길이보다 긴 경우 -> 정답의 처음 데이터와 다시 비교!
                if (answers[i] == pattern[j][i % pattern[j].length]){
                    score[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(score).max().getAsInt();
        
        ArrayList<Integer> student = new ArrayList<>();
        
        for (int i=0; i<score.length; i++){
            if (score[i] == maxScore){
                student.add(i+1);
            }
        }
        
        return student.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < t; i++) {
            int[] answers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            System.out.println(Arrays.toString(solution(answers)));
        }
    }
    
}
