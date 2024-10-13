import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    static int K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]); //배열의 크기
        K = Integer.parseInt(NK[1]); //교환 횟수

        int[] A = new int[N];
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(nums[i]);
        }

        quickSort(A, 0, N-1);

        if (cnt < K) {
            System.out.print("-1");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1); //왼쪽 분리 집합 정렬
            quickSort(arr, pivot+1, end); //오른쪽 분리 집합 정렬
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; //맨 우측 값으로 피벗 지정
        int idx = start-1; //인덱스 시작

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) { //피벗보다 작은 값들을 좌로 보냄
                idx++;
                swap(arr, idx, i);
            }
        }

        if (idx+1 != end) { //피벗이 제자리에 있는 것이 아니라면
            swap(arr, idx+1, end); //피벗 위치 조정
        }

        return idx+1; //피벗 값 반환
    }

    public static void swap(int[] arr, int a, int b) {
        int num = arr[a];
        arr[a] = arr[b];
        arr[b] = num;

        cnt++;
        if (cnt == K) {
            System.out.print(arr[a] + " " + arr[b]);
        }
    }
}