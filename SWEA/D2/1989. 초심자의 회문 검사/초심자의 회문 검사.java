import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            String word = br.readLine().trim();
            int len = word.length();

            int answer = 1;

            for (int i = 0; i < len/2; i++) {
                if (word.charAt(i) != word.charAt(len-i-1)) {
                    answer = 0;
                    break;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
