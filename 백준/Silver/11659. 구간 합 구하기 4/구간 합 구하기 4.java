import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]); //배열 내 숫자의 수
        int M = Integer.parseInt(st[1]); //계산 횟수

        int[] nums = new int[N+1];

        st = (br.readLine()).split(" ");

        //합배열 생성
        for (int i = 1; i <= N; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st[i-1]);
        }

        for (int j = 0; j < M; j++) {
            st = (br.readLine()).split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);

            System.out.println(nums[b] - nums[a-1]);
        }
    }
}