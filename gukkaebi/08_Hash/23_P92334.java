import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // int[] answer = {};
        // return answer;

        // id_list : ["muzi", "frodo", "apeach", "neo"]
        // report : ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
        // k : 2

        // result : [2,1,1,0]

        // 같은 유저를 여러 번 신고한 경우는 신고 횟수 1회로 처리

        Map<String, Integer> reportedMap = new HashMap<>(); // 신고 당한 횟수를 저장
        Map<String, List<String>> userMap = new HashMap<>();

        Set<String> set = new HashSet<>(Arrays.asList(report));

        for (int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], new ArrayList<>());
            reportedMap.put(id_list[i], 0);
        }

        for (String item : set) {
            String[] user = item.split(" ");

            reportedMap.put(user[1], reportedMap.get(user[1]) + 1);
            userMap.get(user[0]).add(user[1]);
        }

        int[] answer = new int[id_list.length];

        int idx = 0;
        for (String id : id_list) {
            for (String reportedUser : userMap.get(id)) {
                if (reportedMap.get(reportedUser) >= k) {
                    answer[idx]++;
                }
            }
            idx++;
        }

        return answer;
    }
}