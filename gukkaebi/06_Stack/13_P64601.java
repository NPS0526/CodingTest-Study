import java.util.*;

class Solution {
	public int solution(int[][] board, int[] moves) {
		// board :
		// [[0,0,0,0,0],[0,0,(1),0,(3)],[0,(2),5,0,(1)],[(4),2,4,(4),2],[(3),5,1,3,1]]
		// moves : [1,5,3,5,1,2,1,4]
		// int answer = 0;
		// return answer; 4 (터트려져 사라진 인형)

		// 스택을 하나 만들어서, top과 새로 넣을 값을 비교
		// 같으면 팝하고, answer += 1*2
		// 현재 예시에서의 스택 : [4,(3,(1,1),3),2,4]

		Stack<Integer> stack = new Stack<>();

		int answer = 0;
		int n = board.length;
		// board[0][0], [1][0], [2][0]
		for (int move : moves) {
			for (int i = 0; i < n; i++) {
				if (!stack.isEmpty() && stack.peek() == board[i][move - 1]) {
					stack.pop();
					answer += 2;
					board[i][move - 1] = 0;
					break;
				}
				if (board[i][move - 1] != 0) {
					stack.push(board[i][move - 1]);
					board[i][move - 1] = 0;
					break;
				}
			}

		}

		return answer;
	}
}