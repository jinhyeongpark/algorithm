
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
            StringTokenizer st;

            int[][] matrix = new int[9][9];

            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < 9; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 1;

            // 가로 확인
            for (int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    set.add(matrix[i][j]);
                }
                if (set.size() != 9) {
                    answer = 0;
                    break;
                }
            }

            // 세로 확인
            for (int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    set.add(matrix[j][i]);
                }
                if (set.size() != 9) {
                    answer = 0;
                    break;
                }
            }

            // 3x3 확인
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    Set<Integer> set = new HashSet<>();
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            set.add(matrix[i+r][j+c]);
                        }
                    }
                    if (set.size() != 9) {
                        answer = 0;
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}