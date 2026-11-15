
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
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 퍼즐 초기화
            int[][] matrix = new int[N][N];

            // 퍼즐 구현
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int row = 0;
            int col = 0;

            // 가로 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N-K+1; j++) {
                    int num = 0;
                    for (int k = 0; k < K; k++) {
                        num += matrix[i][j+k];
                    }
                    if (num == K) {
                        boolean leftOk = (j == 0) || (matrix[i][j-1] == 0); // 왼쪽이 없거나 0
                        boolean rightOk = (j+K == N) || (matrix[i][j+K] == 0);
                        if (leftOk && rightOk) row++;
                    }
                }
            }

            // 세로 탐색
            for (int i = 0; i < (N-K+1); i++) {
                for (int j = 0; j < N; j++) {
                    int num = 0;
                    for (int k = 0; k < K; k++) {
                        num += matrix[i+k][j];
                    }
                    if (num == K) {
                        boolean ceilOk = (i == 0) || (matrix[i-1][j] == 0);
                        boolean flowOk = (i+K == N) || (matrix[i+K][j] == 0);
                        if (ceilOk && flowOk) col ++;
                    }
                }
            }

            int answer = row + col;
            System.out.println("#" + test_case + " " + answer);

        }
    }
}