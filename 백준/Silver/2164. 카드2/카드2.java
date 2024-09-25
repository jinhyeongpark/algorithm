import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //입력 받을 숫자의 수
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        for (int i = 0; i < n-1; i++) {
            queue.remove();
            queue.add(queue.remove());
        }

        System.out.println(queue.peek());
    }
}