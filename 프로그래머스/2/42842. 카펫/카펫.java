import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int num1 = 0;
        int num2 = 0;
        
        for (int i = (int)(Math.sqrt(yellow)); i > 0; i--) {
            boolean first = (yellow % i == 0);
            boolean second = ((i*2) + ((int)(yellow/i)*2) + 4) == brown;
            if (first && second) {
                num1 = i;
                num2 = (int)(yellow/i);
                break;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = num2 + 2;
        answer[1] = num1 + 2;
        return answer;
    }
}