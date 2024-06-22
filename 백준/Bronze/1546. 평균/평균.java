import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int scores[] = new int[N];
        for(int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }
        Arrays.sort(scores);
        double maxScore = scores[N-1];
        double sum = 0;
        for(int score : scores) {
            sum += score/maxScore*100;
        }
        System.out.printf("%.2f", sum/N);
        }

    }