import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 입력될 숫자의 수
        int[] arr = new int[n]; // n개의 숫자를 저장할 배열

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> numStack = new Stack<>(); // 숫자를 쌓을 스택
        List<String> res = new ArrayList<>(); // +와 -를 저장할 리스트
        int add = 1; // 1부터 시작
        boolean flag = true; // 성공 여부 체크

        for (int num : arr) { // arr 리스트에서 숫자를 하나씩 가져옴
            while (add <= num) {
                numStack.push(add++);
                res.add("+");
            }

            if (!numStack.isEmpty() && num == numStack.peek()) {
                numStack.pop();
                res.add("-");
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            for (String op : res) {
                sb.append(op).append("\n");
            }
        } else {
            sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }
}
