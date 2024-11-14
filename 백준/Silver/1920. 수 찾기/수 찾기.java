import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer nums = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(nums.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());

        nums = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(nums.nextToken());
            if (Arrays.binarySearch(A, target) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            ;
        }
    }
}