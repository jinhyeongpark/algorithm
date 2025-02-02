import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] nr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            int n = Integer.parseInt(nums[0]);
            int r = Integer.parseInt(nums[1]);
            combination(n, r);
        }
        bw.flush();
        bw.close();
    }
    static void combination(int n, int r) throws IOException {
        if (n < r) {
            int temp = n;
            n = r;
            r = temp;
        }

        nr = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            nr[i][1] = i;
            nr[i][0] = 1;
            nr[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                nr[i][j] = nr[i-1][j] + nr[i-1][j-1];
            }
        }
        bw.write(nr[n][r] + "\n");
    }
}