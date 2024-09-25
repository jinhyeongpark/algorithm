import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); //스택
        int n = Integer.parseInt(br.readLine()); //입력 받을 숫자의 수
        int add = 1;
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            while (add <= num) {
                stack.push(add++);
                sb.append("+\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                flag = false;
                break;
            }
        }

        System.out.print(flag ? sb.toString() : "NO\n");
    }
}
