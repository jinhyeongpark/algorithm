
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

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = Integer.parseInt(br.readLine().trim());

            int[][] matrix = new int[N][N];

            int currentRow = 0;
            int currentCol = 0;
            int direction = 0;

            for (int num = 1; num <= N*N; num++) {
                matrix[currentRow][currentCol] = num;

                int nextRow = currentRow + dr[direction];
                int nextCol = currentCol + dc[direction];

                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || matrix[nextRow][nextCol] != 0) {
                    direction = (direction + 1) % 4;

                    nextRow = currentRow + dr[direction];
                    nextCol = currentCol + dc[direction];
                }

                currentRow = nextRow;
                currentCol = nextCol;
            }
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}