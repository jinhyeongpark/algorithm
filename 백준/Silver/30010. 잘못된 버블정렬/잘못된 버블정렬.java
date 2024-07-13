import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = N-i;
        }
        
        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }
}