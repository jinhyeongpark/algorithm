import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()); //첫 줄 분자
        int B = Integer.parseInt(st.nextToken()); //첫 줄 분모
        st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken()); //둘째 줄 분자
        int D = Integer.parseInt(st.nextToken()); //둘째 줄 분모

        int mol = A * D + B * C;
        int den = B * D;

        int mod = gcd(mol, den);
        
        mol /= mod;
        den /= mod;

        System.out.println(mol + " " + den);
    }
    private static int gcd(int min, int max) {
        while (min != 0) {
            int mod = max % min;
            max = min;
            min = mod;
        }
        return max;
    }
}