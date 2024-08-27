import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1; //카운트

        int right = 1, left = 1;
        int sum = 1;

        while (right < N) {

            if (sum > N) {
                sum -= left;
                left++;
            } else if (sum < N) {
                right++;
                sum += right;
            } else {
                right++;
                sum += right;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}