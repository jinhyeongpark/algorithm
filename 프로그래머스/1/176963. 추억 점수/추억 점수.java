import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int len = name.length;
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String person : photo[i]) {
                score += scoreMap.getOrDefault(person, 0);
            }
            answer[i] = score;
        }
        return answer;
    }
}