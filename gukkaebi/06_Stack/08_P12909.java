import java.util.*;

class Solution {
	boolean solution(String s) {
		int n = s.length();
		if (s.charAt(0) == ')' || s.charAt(n - 1) == '(') {
			return false;
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				cnt += 1;
			} else {
				cnt -= 1;
				if (cnt < 0) {
					return false;
				}
			}
		}
		if (cnt > 0) {
			return false;
		}
		return true;

	}
}