import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] nr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int r = Integer.parseInt(nums[1]);
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

        System.out.println(nr[n][r]);
    }
}