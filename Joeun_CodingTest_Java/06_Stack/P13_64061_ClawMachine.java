import java.util.*;
public class P13_64061_ClawMachine { // 크레인 인형 뽑기 게임
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayDeque<Integer> basket = new ArrayDeque<>();
        for (int move: moves){
            for (int i = 0; i < board.length; i++){
                //System.out.println(board[i][move-1]);
                if (board[i][move-1] != 0){ // 인형이 담겨있으면
                    if (basket.isEmpty()){ // 바구니가 비어있으면 넣기
                        basket.push(board[i][move-1]);
                    } else{ // 바구니가 비어있지 않으면
                        if (board[i][move-1] == basket.peek()){ // 바구니 맨 위와 뽑은 인형이 같으면 사라짐
                            basket.pop();
                            answer += 2;
                        } else { // 바구니 맨 위와 뽑은 인형이 다르면 바구니에 넣기
                            basket.push(board[i][move-1]);
                        }
                    }
                    board[i][move-1] = 0;
                    //System.out.println(basket);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P13_64061_ClawMachine p = new P13_64061_ClawMachine();
        System.out.println(p.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4})); // 4
    }
}