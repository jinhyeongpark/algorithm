import java.io.*;
import java.util.*;

public class Main {

    static long cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        mergeSort(arr);
        System.out.println(cnt);

    }
    static void mergeSort(long[] arr) {
        long[] brr = new long[arr.length];
        mergeSort(arr, brr, 0, arr.length - 1);
    }

    static void mergeSort(long[] arr, long[] brr, int low, int high) {
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(arr, brr, low, mid);
            mergeSort(arr, brr, mid+1, high);
            merge(arr, brr, low, mid, high);
        }
    }

    static void merge(long[] arr, long[] brr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = low;

        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j])
                brr[index++] = arr[i++];
            else {
                brr[index++] = arr[j++];
                cnt += (mid + 1 - i);
            }
        }

        while(i <= mid)
            brr[index++] = arr[i++];

        while(j <= high)
            brr[index++] = arr[j++];

        for (int k = low; k <= high; k++)
            arr[k] = brr[k];
    }
}