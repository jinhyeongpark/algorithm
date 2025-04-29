import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> negList = new ArrayList<>(N);
        List<Integer> posList = new ArrayList<>(N);

        // 1) 입력을 받으면서 음수/양수 분리 (음수는 절댓값으로 저장)
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x < 0) negList.add(-x);
            else       posList.add(x);
        }

        // 2) 리스트를 배열로 변환
        int[] neg = negList.stream().mapToInt(Integer::intValue).toArray();
        int[] pos = posList.stream().mapToInt(Integer::intValue).toArray();

        // 3) 절댓값 기준으로 Radix Sort 적용
        radixSort(neg);
        radixSort(pos);

        // 4) 음수 부분은 정렬된 절댓값 배열을 뒤집어서 실제 음수로 복원하며 출력
        for (int i = neg.length - 1; i >= 0; i--) {
            bw.write(String.valueOf(-neg[i]));
            bw.newLine();
        }
        // 5) 양수 부분은 정순 그대로 출력
        for (int v : pos) {
            bw.write(String.valueOf(v));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // Radix Sort: 10진수 기반, O(n·k)
    static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        // 1) 최댓값 찾아서 자릿수 수 계산
        int max = Arrays.stream(arr).max().getAsInt();
        int exp = 1;  // 1의 자리, 10의 자리, 100의 자리, ...

        int[] buf = new int[arr.length];

        // 2) 각 자릿수별로 안정 정렬 수행
        while (max / exp > 0) {
            int[] count = new int[10];

            // (a) 해당 자릿수 숫자별 개수 세기
            for (int v : arr) {
                int digit = (v / exp) % 10;
                count[digit]++;
            }
            // (b) 누적합으로 위치 계산
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            // (c) 뒤에서부터 버킷에 맞춰 복사 (안정 정렬)
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = (arr[i] / exp) % 10;
                buf[--count[digit]] = arr[i];
            }
            // (d) 임시 버퍼를 원본으로 복사
            System.arraycopy(buf, 0, arr, 0, arr.length);

            exp *= 10;  // 다음 자릿수로 이동
        }
    }
}
