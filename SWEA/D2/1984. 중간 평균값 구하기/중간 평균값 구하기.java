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

            int sum = 0;

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = st.countTokens();

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                if (max < num) max = num;
                if (min > num) min = num;
            }

            sum -= (min + max);
            long avg = Math.round((double)sum/(size-2));

            System.out.println("#" + test_case + " " + avg);
        }
    }
}
