import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] mat, dp, dp2;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        mat = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        dp2 = new int[N+2][N+2];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = mat[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        for (int i = N; i >= 1; i--) {
            for (int j = N; j >= 1; j--) {
                dp2[i][j] = mat[i][j] + Math.max(dp2[i+1][j], dp2[i][j+1]);
            }
        }
        
        int P = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int score = dp[a][b] + dp2[a][b] - mat[a][b];
            if (score > res) res = score;
        }
        System.out.println(res);
    }
}