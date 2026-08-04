package Set;

import java.util.*;

public class P12981 {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        
        wordSet.add(words[0]);
        for(int i=1; i<words.length; i++){
            String word = words[i];
            
            if(wordSet.contains(word) || word.charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                return new int[]{(i%n) + 1, (i/n) + 1};
            }
            wordSet.add(word);
        }
        return new int[]{0, 0};
    }
}
