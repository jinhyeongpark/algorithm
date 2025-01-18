import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //동전의 수
        int K = Integer.parseInt(st.nextToken()); //가격

        int[] coins = new int[10];
        int res = 0;

        for (int i = N - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            if (K >= coins[i]) {
                res += K / coins[i];
                K %= coins[i];
            }
        }
        System.out.println(res);
    }
}