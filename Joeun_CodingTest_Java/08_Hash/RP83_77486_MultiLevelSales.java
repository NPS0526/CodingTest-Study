import java.util.*;

public class RP83_77486_MultiLevelSales { // 오픈 채팅방
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 해시맵 enroll:referral
        HashMap<String,String> group = new HashMap<>();
        for (int i = 0; i < enroll.length; i++){
            group.put(enroll[i],referral[i]);
        }
        // 해시맵 enroll:수익
        HashMap<String,Integer> result = new HashMap<>();
        
        // 수익 분배
        for (int i = 0; i < seller.length; i++){
            calProfit(group,result,seller[i],amount[i]*100);
        }
        
        // 답 생성
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++){
            if (result.containsKey(enroll[i])){
                answer[i] = result.get(enroll[i]);
            } else {
                answer[i] = 0;
            }
            
        }
        
        return answer;
    }
    
    public void calProfit(HashMap<String,String> group,HashMap<String,Integer> result,String seller,int amount){
        double tmp = amount * 0.1;
        int ref = (int) (tmp - tmp % 1); // 원 단위 절사
        
        // 추천인이 없거나 절사한 금액이 1원 미만인 경우 자신이 모두 가짐
        if (group.get(seller).equals("-") || ref < 1){
            result.merge(seller,amount-ref,Integer::sum);
            //System.out.println(amount-ref+" to "+seller);
        } else {
            result.merge(seller,amount-ref,Integer::sum);
            //System.out.println((amount-ref)+" to "+seller);
            calProfit(group, result, group.get(seller), ref);
        }
    }

    public static void main(String[] args) {
        RP83_77486_MultiLevelSales p = new RP83_77486_MultiLevelSales();
        System.out.println(Arrays.toString(p.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, 
        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, 
        new String[]{"young", "john", "tod", "emily", "mary"}, 
        new int[]{12, 4, 2, 5, 10}))); // [360, 958, 108, 0, 450, 18, 180, 1080]
    }
}