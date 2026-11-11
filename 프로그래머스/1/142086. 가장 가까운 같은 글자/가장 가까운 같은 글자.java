import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            
            if (!map.containsKey(word)) {
                map.put(word, i);
                answer[i] = -1;
            } else {
                answer[i] = i-map.get(word);
                map.put(word, i);
            }
        }
        
        return answer;
    }
}