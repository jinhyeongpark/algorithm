// tip: each public class is put in its own file
import java.util.*;
import java.io.*;

public class Solution
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int j = 0; j < (N-M+1); j++) {
                for (int k = 0; k < (N-M+1); k++) {
                    int answer = 0;
                    for (int l = j; l < j+M; l++) {
                        for (int m = k; m < k+M; m++) {
                            answer += matrix[l][m];
                        }
                    }
                    max = Math.max(max, answer);
                }
            }
            System.out.println("#" + (i+1) + " " + max);
        }
    }
}