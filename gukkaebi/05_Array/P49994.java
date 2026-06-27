import java.util.HashSet;
import java.util.Set;
import java.util.List;

class Solution {
	public int solution(String dirs) {
		Set<List<List<Integer>>> set = new HashSet<>();

		int curr_x = 0;
		int curr_y = 0;

		int n = dirs.length();

		for (int i = 0; i < n; i++) {
			int next_x = curr_x;
			int next_y = curr_y;

			if (dirs.charAt(i) == 'U') {
				next_y += 1;
			} else if (dirs.charAt(i) == 'L') {
				next_x -= 1;
			} else if (dirs.charAt(i) == 'R') {
				next_x += 1;
			} else {
				next_y -= 1;
			}

			if (next_x < -5 || next_x > 5 || next_y > 5 || next_y < -5) {
				continue;
			}

			set.add(List.of(List.of(curr_x, curr_y), List.of(next_x, next_y)));
			set.add(List.of(List.of(next_x, next_y), List.of(curr_x, curr_y)));

			curr_x = next_x;
			curr_y = next_y;
		}
		return set.size() / 2;
	}
}