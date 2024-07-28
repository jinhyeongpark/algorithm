import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int cnt = 0;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);

        bw.write(cnt + "\n");
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void hanoi(int N, int from, int to, int temp) {
        if (N == 1) {
            result.append(from).append(" ").append(to).append("\n");
            cnt++;
        } else {
            hanoi(N-1, from, temp, to);
            result.append(from).append(" ").append(to).append("\n");
            cnt++;
            hanoi(N-1, temp, to, from);
        }
    }
}