
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());

            // 행렬 구축
            String[][] matrix = new String[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = st.nextToken();
                }
            }

            String[][] answer = new String[N][3];

            // 90도
            for (int i = 0; i < N; i++) {
                StringBuilder num = new StringBuilder();
                for (int j = N-1; j >= 0; j--) {
                    num.append(matrix[j][i]);
                }
                answer[i][0] = num.toString();
            }

            // 180도
            for (int i = N-1; i >= 0; i--) {
                StringBuilder num = new StringBuilder();
                for (int j = N-1; j >= 0; j--) {
                    num.append(matrix[i][j]);
                }
                answer[N-1-i][1] = num.toString();
            }

            // 270도
            for (int i = N-1; i >= 0; i--) {
                StringBuilder num = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    num.append(matrix[j][i]);
                }
                answer[N-1-i][2] = num.toString();
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}