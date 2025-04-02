import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] idx = new int[n + 1];
        int[] movementsArr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            idx[arr[i]] = i;
        }

        for (int i = 1; i < n; i++) {
            int move = idx[i] - i;
            int temp = arr[i];

            swap(arr, i, idx[i]);
            swap(idx, i, temp);

            movementsArr[i] += Math.abs(move);
            movementsArr[temp] += Math.abs(move);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(movementsArr[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}