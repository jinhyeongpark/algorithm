import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static long M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //나무 수
        M = Integer.parseInt(st.nextToken()); //원하는 나무 길이

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch(arr));

    }
    //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    private static long binarySearch(int[] arr) {
        long left = 0;
        long right = arr[arr.length - 1];
        long res = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (M <= findOut(arr, mid)) { //남는 경우
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private static long findOut(int[] arr, long num) {
        long res = 0;
        for (int n : arr) {
            if (n-num > 0) res += (n-num);
        }
        return res;
    }
}