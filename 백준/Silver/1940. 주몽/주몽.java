import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] strNums = br.readLine().split(" ");
        int[] nums = Arrays.stream(strNums).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        int start = 0;
        int end = N-1;
        int cnt = 0;


        while (start < end) {

            int sum = nums[start] + nums[end];

            if (sum < M) {
                start++;
            }
            else if (sum == M) {
                cnt++;
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println(cnt);

    }
}