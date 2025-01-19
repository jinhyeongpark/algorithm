import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] nums = new int[num + 1];
        for (int i = 2; i < nums.length; i++) {
            nums[i] = i;
        }

        for (int i = 2; i * i <= num; i++) {
            if (nums[i] > 0) {
                for (int j = i * i; j <= num; j += i) {
                    nums[j] = 0;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (nums[i] > 0) {
                primes.add(i);
            }
        }
        int count = 0;
        int left = 0, right = 0, sum = 0;

        while (right < primes.size()) {
            if (sum < num) {
                sum += primes.get(right++);
            } else if (sum > num) {
                sum -= primes.get(left++);
            } else { // sum == num
                count++;
                sum += primes.get(right++);
            }
        }
        if (nums[num] > 0) {
            count++;
        }
        System.out.println(count);
    }
}