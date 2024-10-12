import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //merge 함수: 두 개의 정렬된 부분 배열을 합치는 함수
    public static void merge(int[] A, int p, int q, int r) {
        int i = p, j = q + 1, t = 0;
        int[] tmp = new int[r - p + 1]; // 임시 배열 생성

        //두 배열을 비교하며 tmp에 값을 저장
        while (i <= q && j <= r) {
            if (A[i] < A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }
        //어느 한 쪽이 빈 경우
        //왼쪽 배열에 남은 값을 모두 tmp에 복사
        while (i <= q) {
            tmp[t++] = A[i++];
        }

        //오른쪽 배열에 남은 값을 모두 tmp에 복사
        while (j <= r) {
            tmp[t++] = A[j++];
        }

        //tmp 배열의 값을 A[p..r]에 복사
        t = 0;
        for (i = p; i <= r; i++) {
            A[i] = tmp[t++];
        }
    }

    // mergeSort 함수: 배열을 재귀적으로 분할하고 병합하는 함수
    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2; // 중간 인덱스 계산
            mergeSort(A, p, q);   // 왼쪽 부분 배열 정렬
            mergeSort(A, q + 1, r); // 오른쪽 부분 배열 정렬
            merge(A, p, q, r); // 두 부분 배열을 병합
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //수의 갯수 N 입력받기

        int[] arr = new int[N]; //N크기의 배열 생성

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); //N개의 수 입력받기
        }

        //병합 정렬 실행
        //배열, 시작 인덱스, 끝 인덱스를 매개변수로
        mergeSort(arr, 0, arr.length-1);

        //출력
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}