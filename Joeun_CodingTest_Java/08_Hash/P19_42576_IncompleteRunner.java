import java.util.*;

public class P19_42576_IncompleteRunner { // 완주하지 못한 선수
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> mCompletion = new HashMap<>();
        for (String who : completion){
            mCompletion.merge(who, 1, Integer::sum);
        }
        
        for (String who : participant){
            if (!mCompletion.containsKey(who) || mCompletion.get(who) == 0){
                return who;
            }
            mCompletion.merge(who, -1, Integer::sum);
        }
        
        return null;
    }

    public static void main(String[] args) {
        RP73_17678_ShuttleBust p = new RP73_17678_ShuttleBust();
        System.out.println(p.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"})); // "leo"
    }
}