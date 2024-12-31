import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ')') {
                stack.pop();
                if (s.charAt(i-1) == '(') {
                    ans += stack.size();
                } else {
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}