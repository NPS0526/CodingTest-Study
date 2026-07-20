import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고자 : 신고한 사람 세트
        HashMap<String,HashSet<String>> report_map = new HashMap<>();
        for (String r : report){
            String[] list = r.split(" ");
            if (!report_map.containsKey(list[0])){
                report_map.put(list[0],new HashSet<>());
            }
            report_map.get(list[0]).add(list[1]);
        }
        
        // 신고 당한 사람 횟수 세기
        HashMap<String, Integer> reported_map = new HashMap<>();
        for (Map.Entry<String,HashSet<String>> entry : report_map.entrySet()){
            for (String id : entry.getValue()){
                reported_map.merge(id,1,Integer::sum);
            }
        }
        
        // 신고한 사람 중에 정지당한 사람 개수 세기
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            for (String id : report_map.getOrDefault(id_list[i], new HashSet<>())){
                if (reported_map.getOrDefault(id, 0) >= k){
                    answer[i] += 1;
                }
            }
        }
        
        return answer;
    }
}

public class P23_92334_GetReport { // 신고 결과 받기
    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(Arrays.toString(p.solution(
            new String[]{"muzi", "frodo", "apeach", "neo"}, 
            new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 
            2))); // [2, 1, 1, 0]
    }
}