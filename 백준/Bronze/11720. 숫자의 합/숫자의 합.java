import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        String num = sc.next();
        int sum = 0;

        char[] charArray = num.toCharArray();
        for (int i = 0; i < num.length(); i++) {
            sum += Character.getNumericValue(charArray[i]);
        }
        System.out.println(sum);
    }

}