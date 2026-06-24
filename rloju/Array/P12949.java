package Array;

import java.util.Arrays;

public class P12949 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int M = arr2.length;    // arr1의 열 수 = arr2의 행 수
        int K = arr2[0].length;
        
        int[][] result = new int[N][K];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        //int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        //int[][] arr2 = {{3, 3}, {3, 3}};
        
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        
        for (int[] row : solution(arr1, arr2))
            System.out.println(Arrays.toString(row));
    }

}
