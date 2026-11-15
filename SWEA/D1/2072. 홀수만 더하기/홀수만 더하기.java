import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. T 읽기 (줄 단위로 읽어서 정수 변환)
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            // 2. 한 줄 통째로 읽어 토큰 분리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 != 0) {
                    answer += num;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}