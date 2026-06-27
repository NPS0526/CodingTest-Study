import java.util.*;

class Solution {
	boolean solution(String s) {
//		ArrayDeque : 앞과 뒤 양쪽에서 데이터를 넣고 뺄 수 있는 구조
//		toCharArray() : 문자열을 문자들의 배열로 쪼개주는 매서드
//		Character : 기본 자료형인 char를 객체로 다루기 위해 씌워놓은 Wrapper Class

		ArrayDeque<Character> stack = new ArrayDeque<>();

		char[] a = s.toCharArray();
		for (char c : a) {
			if (c == '(') {
				stack.push(c);

			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}