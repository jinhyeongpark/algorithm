import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long nums[] = new long[N+1]; //사람이 카운트하는 방식과 똑같이 하기 위함
        //합배열 생성
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
        }

        //구간 합
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(nums[j] - nums[i-1]);
        }
    }
}