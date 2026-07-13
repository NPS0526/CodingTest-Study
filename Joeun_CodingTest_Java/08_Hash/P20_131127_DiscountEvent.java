import java.util.*;

public class P20_131127_DiscountEvent { // 할인 행사
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> want_list = new HashMap<>();
        for (int i = 0; i < want.length; i++){
            want_list.put(want[i], number[i]);
        }
        
        for(int i = 1; i + 9 <= discount.length; i++){
            HashMap<String, Integer> map = new HashMap<>(want_list);
            for (int j = i; j < i + 10; j++){
                if (map.containsKey(discount[j-1])){
                    map.put(discount[j-1],map.get(discount[j-1])-1);
                    if (map.get(discount[j-1]).equals(0)){
                        map.remove(discount[j-1]);
                    }
                } else {
                    break;
                }
            }
            if (map.isEmpty()){
                answer += 1;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        P20_131127_DiscountEvent p = new P20_131127_DiscountEvent();
        System.out.println(p.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"})); // 3
    }
}