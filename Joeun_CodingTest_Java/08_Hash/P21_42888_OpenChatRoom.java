import java.util.*;

public class P21_42888_OpenChatRoom { // 오픈 채팅방
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        ArrayList<String> result = new ArrayList<>(); // 마지막에 result 기반으로 답 생성
        
        // record 마다 명령 처리
        for (int i = 0; i < record.length; i++){
            String[] command = record[i].split(" ");
            switch(command[0]){
                case "Enter":
                    userMap.put(command[1],command[2]);
                    result.add(command[0]+" "+command[1]);
                    break;
                case "Leave":
                    result.add(command[0]+" "+command[1]);
                    break;
                case "Change":
                    userMap.put(command[1],command[2]);
                    break;
            }
        }
        // 답 생성
        for (int i = 0; i < result.size(); i++){
            String[] command = result.get(i).split(" ");
            switch (command[0]){
                case "Enter":
                    result.set(i,userMap.get(command[1])+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    result.set(i,userMap.get(command[1])+"님이 나갔습니다.");
                    break;
            }
        }
        
        String[] answer = result.toArray(new String[0]);
        return answer;
    }

    public static void main(String[] args) {
        P21_42888_OpenChatRoom p = new P21_42888_OpenChatRoom();
        System.out.println(Arrays.toString(p.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}))); // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    }
}