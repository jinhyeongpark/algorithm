import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int nums[] = new int[N];
        int sums[] = new int[N];
        //배열 생성
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        //합배열 생성
        sums[0] = nums[0];
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        //구간 합
        for (int k = 0; k < M; k++) {
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;
            if (i >= 1) {
                System.out.println(sums[j] - sums[i-1]);
            } else {
                System.out.println(sums[j]);
            }

        }
        sc.close();
    }
}