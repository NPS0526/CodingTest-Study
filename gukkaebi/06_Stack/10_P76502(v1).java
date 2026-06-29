import java.util.*;

class Solution {
	public int solution(String s) {
//    	파이썬으로 치면 map = {')' : '('}  	=> HashMap<Character, Character> map = new HashMap<>();
//    	if ')' in map: 					=> if (map.containsKey(')')) {}
//    	pair = map[')'] 				=> char pair = map.get(')');
//    	map['}'] = '{' 					=> map.put('}', '{');

		HashMap<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

//        System.out.print(map);
		int n = s.length();
		s += s;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			ArrayDeque stack = new ArrayDeque<>();
			boolean flag = true;

			for (int j = i; j < i + n; j++) {
				char c = s.charAt(j);

				if (!map.containsKey(c)) {
					stack.push(c);
				} else {
					if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
						flag = false;
						break;
					}
				}
			}
			if (flag && stack.isEmpty()) {
				answer++;
			}
		}

		return answer;
	}
}