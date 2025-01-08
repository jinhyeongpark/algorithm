import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //데이터의 수
        Stack<Character> stack = new Stack<>();

        String[] s = br.readLine().split("");

        boolean flag = false; //반전 문자를 받는 모드

        for (int i = 0; i < s.length; i++) {
            char word = s[i].charAt(0);
            if (word == '<') { //개행
                while(!stack.isEmpty()) { //이전까지의 반전 문자들 출력
                    bw.write(stack.pop());
                }
                flag = true; //비반전 문자를 받는 모드
                bw.write(word);
            }
            else if (word == '>') {
                flag = false;
                bw.write(word);
            }
            else if (flag) {
                bw.write(word); //'<' ~ '>' 문자들을 그대로 출력
            }
            else {
                if (word == ' ') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(' ');
                }
                else {
                    stack.push(word);
                }
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();
    }
}