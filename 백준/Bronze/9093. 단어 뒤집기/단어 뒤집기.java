import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuilder word = new StringBuilder(st.nextToken());
                sb.append(word.reverse()).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
