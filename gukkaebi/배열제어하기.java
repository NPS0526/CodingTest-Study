import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

class Solution {
	private static int[] solution(int[] arr) {
//		스트림 사용
		Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

		Arrays.sort(result, Collections.reverseOrder());

		return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
		
//		스트림을 사용하지 않고 기본 반복문으로 풀기
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for (int num : arr) {
			set.add(num);
		}
		
		int[] result = new int[set.size];
		
		for (int i =0; i<result.length; i++) {
			result[i] = set.pollFirst();
		}
		
		return result
	}
}