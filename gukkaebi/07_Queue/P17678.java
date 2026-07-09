import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

        // timetable 정수 변환
        int[] crews = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            int hour = Integer.parseInt(timetable[i].split(":")[0]);
            int minute = Integer.parseInt(timetable[i].split(":")[1]);
            crews[i] = hour * 60 + minute;
        }

        // 오름차순 정렬
        Arrays.sort(crews);

        // 버스 출발 시간 배열
        int[] buses = new int[n];
        for (int i = 0; i < n; i++) {
            buses[i] = 60 * 9 + t * i;
        }

        int idx = 0;
        int con_time = 0;
        for (int bus : buses) {
            int boarded_cnt = 0;
            while (boarded_cnt < m && idx < crews.length) {
                if (crews[idx] <= bus) {
                    idx++;
                    boarded_cnt++;
                } else {
                    break;
                }
            }

            if (bus == buses[n - 1]) {
                if (boarded_cnt == m) {
                    con_time = crews[idx - 1] - 1;
                } else {
                    con_time = bus;
                }
            }
        }

        String answer = String.format("%02d:%02d", con_time / 60, con_time % 60);

        return answer;

    }
}