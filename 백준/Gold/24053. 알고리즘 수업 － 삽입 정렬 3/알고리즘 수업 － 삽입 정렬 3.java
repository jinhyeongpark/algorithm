import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //배열 선언
        int[] arrA = new int[N];
        int[] arrB = new int[N];
        //배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        if (Arrays.equals(arrA, arrB)) {
            System.out.println(1);
        } else {
            sort(arrA, arrB);
            System.out.println(result);
        }
    }
    static void sort(int[] arrA, int[] arrB) {
        for (int i = 1; i < arrA.length; i++) {
            int idx = i - 1;
            int newItem = arrA[i];

            while (idx >= 0 && newItem < arrA[idx]) {
                arrA[idx + 1] = arrA[idx];
                idx--;
                //System.out.println("Current arrA: " + Arrays.toString(arrA));
                if (Arrays.equals(arrA, arrB)) {
                    result = 1;
                    return;
                }
            }
            if (idx + 1 != i) arrA[idx + 1] = newItem;

        }
    }
}