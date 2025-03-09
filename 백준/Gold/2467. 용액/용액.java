import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = N-1;
        int bestSum = nums[left] + nums[right];
        int[] results = {nums[left], nums[right]};

        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (Math.abs(currentSum) < Math.abs(bestSum)) {
                bestSum = currentSum;
                results[0] = nums[left];
                results[1] = nums[right];
            }
            if (currentSum == 0) {
                break;
            } else if (currentSum > 0) {
                right--;
            } else {
                left++;
            }
        }
        Arrays.sort(results);
        System.out.println(results[0]+ " "+results[1]);
    }
}