package Hash;

import java.util.HashMap;
import java.util.Map;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(String p : participant){
            hash.put(p, hash.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion){
            int cnt = hash.get(c);
            if(cnt == 1) hash.remove(c);
            else hash.put(c, cnt-1);
        }
        
        Map.Entry<String, Integer> en = hash.entrySet().stream().findFirst().get();
        return en.getKey();
    }
}
