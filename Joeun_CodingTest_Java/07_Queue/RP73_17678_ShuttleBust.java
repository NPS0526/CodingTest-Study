import java.util.*;

public class RP73_17678_ShuttleBust { // 셔틀버스
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        // 시간 * 60 + 분으로 변환
        int[] iTimetable = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++){
            iTimetable[i] = Integer.parseInt(timetable[i].substring(0,2)) * 60 + Integer.parseInt(timetable[i].substring(3,5));
        }
        Arrays.sort(iTimetable);
        
        // 버스에 탄 사람 체크
        int bus_time = 0; int last_crew = 0;
        boolean flag = true;
        int qIdx = 0;
        int cnt = 0;
        
        for (int i = 0; i < n; i++){
            bus_time = 9 * 60 + (t * i);
            cnt = 0;
            while (cnt < m){
                if (qIdx == timetable.length){
                    break;
                }
                
                if (iTimetable[qIdx] <= bus_time){
                    last_crew = iTimetable[qIdx];
                    cnt++; qIdx++;
                } else {
                    break;
                }
            }
        }
        
        // 언제 도착해야하는지 계산
        int iAnswer = 0;
        if (cnt < m){ // 마지막 버스가 비어있으면 버스 시간에 맞춰서 도착
            iAnswer = bus_time;
        } else { // 가득 차면 한 명만 제끼기 == 마지막 사람 시간보다 1분 일찍 도착
            iAnswer = last_crew - 1;
        }
        
        answer = String.format("%02d:%02d",iAnswer/60, iAnswer%60);
        return answer;
    }

    public static void main(String[] args) {
        RP73_17678_ShuttleBust p = new RP73_17678_ShuttleBust();
        System.out.println(p.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"})); // "09:00"
    }
}