package Hash;

import java.util.HashMap;
import java.util.ArrayList;

public class P42888 {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        for(String s : record){
            String[] word = s.split(" ");
            if(word[0].equals("Enter") || word[0].equals("Change")) map.put(word[1], word[2]);
        }
        
        for(String s : record){
            String[] word = s.split(" ");
            if(word[0].equals("Enter")) result.add(map.get(word[1]) + "님이 들어왔습니다.");
            else if(word[0].equals("Leave")) result.add(map.get(word[1]) + "님이 나갔습니다.");
        }
        return result.toArray(String[]::new);
    }
}
