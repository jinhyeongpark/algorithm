import java.io.*;
import java.util.*;

public class Main {
    //단어 공부: 가장 많이 사용된 알파벳
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine(); //단어 입력 받기
        word = word.toUpperCase(); //모두 대문자로 변경
        char[] wordArr = word.toCharArray(); //문자 배열로 변환

        char alphabets[] = new char[26]; //대문자 알파벳 문자 배열 생성
        for(int i = 0; i < 26; i++) {
            alphabets[i] = (char) ('A'+ i);
        }
        int frequency[] = new int[26]; //빈도를 나타낼 정수 배열 생성

        for(int i = 0; i < wordArr.length; i++) { //빈도 검사
            for(int j = 0; j < 26; j++) {
                if(wordArr[i] == alphabets[j]) {
                    frequency[j]++;
                }
            }
        }
        int maxNum = frequency[0];
        boolean flag = true;
        for(int i = 1; i < 26; i++) {
            if(frequency[i] > maxNum) {
                maxNum = frequency[i];
                flag = true;
            } else if(frequency[i] == maxNum) {
                flag = false;
            }

        }
        if (flag) {
            for (int i = 0; i < 26; i++) {
                if (frequency[i] == maxNum) {
                    System.out.println(alphabets[i]);
                    break;
                }
            }
        } else {
            System.out.println("?");
        }
    }
}