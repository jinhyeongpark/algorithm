import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length-2; i++) { 
            int firstNum = number[i];
            for (int j = i+1; j < number.length-1; j++) { 
                int secondNum = number[j];
                for (int k = j+1; k < number.length; k++) {
                    int thirdNum = number[k];
                    if ((firstNum + secondNum + thirdNum) == 0) answer++;
                }
            }
        }
        return answer;
    }
}