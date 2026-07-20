import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // record : ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter
        // uid1234 Prodo","Change uid4567 Ryan"]
        // result : ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이
        // 들어왔습니다."]

        HashMap<String, String> userMap = new HashMap<>();

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] currentCmd = record[i].split(" ");

            if (currentCmd[0].equals("Enter") || currentCmd[0].equals("Change")) {
                userMap.put(currentCmd[1], currentCmd[2]);
            }

        }

        for (int i = 0; i < record.length; i++) {
            String[] currentCmd = record[i].split(" ");

            if (currentCmd[0].equals("Enter")) {
                answer.add(userMap.get(currentCmd[1]) + "님이 들어왔습니다.");
            } else if (currentCmd[0].equals("Leave")) {
                answer.add(userMap.get(currentCmd[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}