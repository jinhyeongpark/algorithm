import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public int[][] solution(int[][] arr) {

        int row = arr.length;
        int col = arr[0].length;
        int len = Math.max(row, col);

        int[][] answer = new int[len][len];

        if (row == col) answer = arr;
        else if (row > col) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
        } else {
            for (int i = 0; i < row; i++) {
                answer[i] = arr[i];
            }
        }
        return answer;
    }
}
