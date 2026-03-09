import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int cnt = 1;
        while (!queue.isEmpty()) {
            int target = queue.poll();
            if (cnt % K == 0) {
                sb.append(target);
                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
                cnt = 0;
            } else {
                queue.add(target);
            }
            cnt++;
        }
        System.out.println(sb.append(">"));
    }
}
