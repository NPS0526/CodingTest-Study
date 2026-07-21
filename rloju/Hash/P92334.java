package Hash;

import java.util.*;

public class P92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reported = new HashMap<>();
        for (String id : id_list) reported.put(id, new HashSet<>());
        
        for (String r : report) {
            String[] parts = r.split(" ");
            reported.get(parts[1]).add(parts[0]);
        }
        
        Set<String> blocked = new HashSet<>();
        for (String id : id_list) {
            if (reported.get(id).size() >= k) blocked.add(id);
        }
        
        Map<String, Integer> message_count = new HashMap<>();
        for (String id : id_list) message_count.put(id, 0);
        
        for (String id : id_list) {
            if (blocked.contains(id)) {
                for (String reporter : reported.get(id)) {
                    message_count.merge(reporter, 1, Integer::sum);
                }
            }
        }
        
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) result[i] = message_count.get(id_list[i]);
        return result;
    }
}
