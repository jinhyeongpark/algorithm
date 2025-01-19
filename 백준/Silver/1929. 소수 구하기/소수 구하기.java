import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int start = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);

        boolean[] isPrime = new boolean[end + 1];
        for (int i = 2; i <= end; i++) {
            isPrime[i] = true; //초기화: 모든 숫자를 소수로 가정
        }

        //에라토스테네스의 체 
        for (int i = 2; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    isPrime[j] = false; // i의 배수는 소수가 아님
                }
            }
        }

        //결과 출력
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}