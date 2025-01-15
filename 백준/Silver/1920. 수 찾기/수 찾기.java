import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            if (binarySearch(A, 0, A.length-1, Integer.parseInt(st.nextToken()))) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }

        }
        bw.flush();
        bw.close();
    }
    private static boolean binarySearch(int[] arr, int start, int end, int num) throws IOException {
        if (start > end) return  false;
        int mid = (start + end) / 2;
        if (num == arr[mid]) {
            return true;
        }
        if (num < arr[mid]) return binarySearch(arr, start, mid-1, num);
        else return binarySearch(arr, mid+1, end, num);
    }
}