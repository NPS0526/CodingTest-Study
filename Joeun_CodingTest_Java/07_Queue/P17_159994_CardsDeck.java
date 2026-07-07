import java.util.*;
import java.util.stream.*;

public class P17_159994_CardsDeck { // 기능 개발
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int iCard1 = 0; int iCard2 = 0; int iGoal = 0;
        
        while(iGoal < goal.length){
            //System.out.println("1: "+cards1[iCard1]+"2: "+goal[iGoal]);
            if (iCard1 < cards1.length && cards1[iCard1].equals(goal[iGoal])){
                iCard1 += 1; iGoal += 1;
            } else if (iCard2 < cards2.length && cards2[iCard2].equals(goal[iGoal])){
                iCard2 += 1; iGoal += 1;
            } else {
                return "No";
            }
        }
        if (iGoal == goal.length) {
            return "Yes";
        }
        
        return "Error";
    }

    public static void main(String[] args) {
        P17_159994_CardsDeck p = new P17_159994_CardsDeck();
        System.out.println(p.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})); // "Yes"
    }
}