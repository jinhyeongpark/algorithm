import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int [] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        //6 3 2 10 10 10 -10 -10 7 3
        //-10 -10 3 2 2 6 7 10 10 10
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int cnt = findLast(nums, num) - findFirst(nums, num);
            bw.write(cnt + " ");
        }
        bw.flush();
        bw.close();

    }
    public static int findFirst(int[] arr, int value) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int middle = (left + right) / 2;
            if (value <= arr[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }
        return left;
    }

    public static int findLast(int[] arr, int value) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int middle = (left + right) / 2;
            if (value < arr[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }
        return left;
    }
}