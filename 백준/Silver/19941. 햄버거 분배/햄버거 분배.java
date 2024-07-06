import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //식탁의 길이
        int K = Integer.parseInt(st.nextToken()); //햄버거 선택 가능 거리
        int count = 0;
        char table[] = br.readLine().toCharArray();

        for(int i = 0; i < N; i++) { //테이블 순회
            if(table[i] == 'P') {
                int start = Math.max(i - K, 0);
                int end = Math.min(i + K, N-1);
                for(int j = start; j <= end; j ++) {
                    if (table[j] == 'H') {
                        table[j] = 'N';
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}