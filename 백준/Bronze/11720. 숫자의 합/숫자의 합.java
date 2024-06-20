import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        String num = sc.next();
        char cNum[] = num.toCharArray();
        for(int i = 0; i < cNum.length; i++) {
            sum += cNum[i]-48;
        }
        System.out.println(sum);
        sc.close();
    }
}
