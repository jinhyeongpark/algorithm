import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        bubbleSort(N, arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void bubbleSort(int N, int[] arr) {
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            flag = true;
            for (int j = 1; j < N-i; j++) {
                if (arr[j-1] > arr[j]) {
                    flag = false;
                    swap(arr, j-1, j);
                }
            }
            if (flag) break;
        }
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}