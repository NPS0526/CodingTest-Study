import java.util.HashMap;

class Solution {
	public int[] solution(int N, int[] stages) {
//        int[] answer = {};
//        return answer;

		int[] challenger = new int[N + 2];
		for (int stage : stages) {
			challenger[stage] += 1;
//			println(challenger[stage]);
		}

		HashMap<Integer, Double> fails = new HashMap<>();

		double total = stages.length;

		for (int i = 1; i <= N; i++) {
			if (challenger[i] == 0) {
				fails.put(i, 0.);
			} else {
				fails.put(i, challenger[i] / total);
				total -= challenger[i];
			}
		}

		return fails.entrySet().stream()
				.sorted((o1, o2) -> o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey())
						: Double.compare(o2.getValue(), o1.getValue()))
				.mapToInt(HashMap.Entry::getKey).toArray();

	}
}