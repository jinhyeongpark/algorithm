import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int M = Integer.parseInt(st.nextToken()); // 기준 값

        int[] nums = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int res = N + 1;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (start <= end && end <= N) { // 조건 수정
            if (sum >= M) { // 조건 순서 변경
                res = Math.min(res, end - start);
                sum -= nums[start++];
            } else if (end < N) {
                sum += nums[end++];
            } else { // sum < M && end == N 인 경우
                break;
            }
        }

        if (res == N+1) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }
}
