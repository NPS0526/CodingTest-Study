package Hash;

import java.util.*;

public class P77486 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> people = new HashMap<>();
        HashMap<String, Integer> profit = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<enroll.length; i++){
            people.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);
        }
        
        //재귀
        for(int i=0; i<seller.length; i++){
            profit_update(seller[i], amount[i] * 100, people, profit);
        }
        
        for(String s : enroll){
            answer.add(profit.get(s));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void profit_update(String name, int money, HashMap<String, String> people, HashMap<String, Integer> profit){
        if(name.equals("-") || money == 0) return;
        
        int parent_profit = money / 10;
        int my_profit = money - parent_profit;
        profit.put(name, profit.get(name) + my_profit);
        
        if(parent_profit>0) profit_update(people.get(name), parent_profit, people, profit);
    }

}
