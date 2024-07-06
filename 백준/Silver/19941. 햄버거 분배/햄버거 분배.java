import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken()); //식탁의 길이
        long K = Integer.parseInt(st.nextToken()); //햄버거 선택 가능 거리
        long count = 0;
        char table[] = br.readLine().toCharArray();

        for(long i = 0; i < N; i++) {
            if(table[(int) i] == 'P') {
                long start = (i-K>=0)?i-K:0;
                long end = (i+K<N)?i+K:N-1;
                for(long j = start; j <= end; j ++) {
                    if (table[(int) j] == 'H') {
                        table[(int) j] = 'N';
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);

    }
}