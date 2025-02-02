import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int r = Integer.parseInt(nums[1]);
        System.out.println(combination(n, r));
    }

    static int combination(int n, int r) {
        return fact(n) / (fact(n-r) * fact(r));
    }

    static int fact(int num) {
        int result = 1;
        for (int i = num; i >= 1; i--) {
            result *= i;
        }
        return result;
    }
}