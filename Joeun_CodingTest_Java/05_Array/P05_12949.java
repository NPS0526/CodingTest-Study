import java.util.*;
public class P05_12949 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        // [행의 개수, 열의 개수]
        int[][] nm = {{arr1.length, arr1[0].length},{arr2.length, arr2[0].length}};
        int[][] result = new int[nm[0][0]][nm[1][1]];
        
        for (int i=0; i<nm[0][0]; i++){ // n의 각 행마다
            for (int j=0; j<nm[1][1]; j++){ // m의 각 열 곱해줌
                for (int k=0; k<nm[0][1]; k++){
                    result[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{3, 4}, {3, 6}};
        int[][] arr2 = {{4, 5}, {4, 5}, {4, 6}};
        int[][] result = solution(arr1, arr2);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}