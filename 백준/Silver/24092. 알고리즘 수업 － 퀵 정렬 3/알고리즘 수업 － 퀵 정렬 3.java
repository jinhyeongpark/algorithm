import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] compareArr;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        res = 0;

        arr = new int[N];
        compareArr = new int[N];
        //배열 A 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i  = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열 B 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i  = 0; i < N; i ++) {
            compareArr[i] = Integer.parseInt(st.nextToken());
        }
        //처음부터 A와 B가 같으면 1 출력 후 마무리
        if (Arrays.equals(arr, compareArr)) {
            System.out.println(1);
        } else {
            sort(arr);
            System.out.println(res);
        }
    }
    static void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }
    static void sort(int[] arr, int low, int high) {
        if (high <= low) return; //길이가 1이 되면종료
        int j = partition(arr, low, high);
        sort(arr, low, j-1); //피벗보다 작은 부분 순환
        sort(arr, j+1, high); //피벗보다 큰 부분 순환
    }
    static int partition(int[] arr, int low, int pivot) {
        int i = low;
        int j = pivot -1;

        while (true) {
            while ((i < pivot) && (arr[i] < arr[pivot])) i++;
            while ((j >= 0) && (arr[j] > arr[pivot])) j--;

            if(i >= j) break;

            swap(arr, i, j);
            if (Arrays.equals(arr, compareArr)) res = 1;
//            System.out.println("A: " + Arrays.toString(arr));
//            System.out.println("B: " + Arrays.toString(compareArr));
        }
        swap(arr, pivot, i);
        if (Arrays.equals(arr, compareArr)) res = 1;
//        System.out.println("A: " + Arrays.toString(arr));
//        System.out.println("B: " + Arrays.toString(compareArr));
        return i;
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}