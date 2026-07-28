
import java.util.*;

public class P32_12981_WordChain {
    public int[] solution(int n, String[] words) {
        HashSet<String> used = new HashSet<>();
        int person = 2;
        used.add(words[0]);
        
        for (int i = 1; i < words.length; i++){
            if (used.contains(words[i])){
                return new int[] {person, i/n+1};
            } else if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                return new int[] {person, i/n+1};
            }
            
            used.add(words[i]);
            person += 1;
            if (person == n+1){
                person = 1;
            }
        }
        
        return new int[] {0,0};
    }

    public static void main(String[] args) {
        P32_12981_WordChain p = new P32_12981_WordChain();
        int[] answer = p.solution(3, 
            new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println(Arrays.toString(answer)); // [3,3];
    }
}