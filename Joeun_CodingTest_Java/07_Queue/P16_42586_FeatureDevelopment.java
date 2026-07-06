import java.util.*;
import java.util.stream.*;

public class P16_42586_FeatureDevelopment { // 기능 개발
    public int[] solution(int[] progresses, int[] speeds) {
        // 초기화
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> qProg = Arrays.stream(progresses).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> qSpeed = Arrays.stream(speeds).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        int version = 1;
        
        while (!qProg.isEmpty()){
            boolean flag = true;
            int fin = 0;
            while (flag){
                // 이번 배포 버전에서 제일 앞의 진도가 끝났는지 체크
                if((qProg.peek() + qSpeed.peek() * version) >= 100){
                    qProg.pollFirst(); qSpeed.pollFirst();
                    fin += 1;
                    if (qProg.isEmpty()) {
                        break;
                    }
                } else{
                    flag = false;
                }
            }
            if (fin != 0){
                answer.add(fin);
            }
            version += 1; 
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        P16_42586_FeatureDevelopment p = new P16_42586_FeatureDevelopment();
        System.out.println(Arrays.toString(p.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); // [2, 1]
    }
}