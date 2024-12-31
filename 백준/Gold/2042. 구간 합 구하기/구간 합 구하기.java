import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //배열을 구성하는 숫자의 수
        int M = Integer.parseInt(st.nextToken()); //변경 횟수
        int K = Integer.parseInt(st.nextToken()); //구간합을 구하는 횟수

        //N개의 숫자를 받아 세그먼트 트리의 리프노드로 구성
        int k = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = (int)Math.pow(2,k) * 2; //세그먼트 트리 크기
        int leaf_start = (int)Math.pow(2, k); //리프노드 시작 인덱스

        long[] nums = new long[size + 1]; //세그먼트 트리 배열 생성

        for (int i = leaf_start; i <leaf_start + N; i++) { //리프노드 입력
            nums[i] = Long.parseLong(br.readLine());
        }

        for(int i = leaf_start - 1; i > 0; i--) {
            nums[i] = nums[2*i] + nums[2*i+1];
        }
        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());


            if (a == 1) {
                update(nums, b, c, k);
            }
            else {
                int start = b + (int)Math.pow(2, k) - 1;
                int end = (int)c + (int)Math.pow(2, k) - 1;
                bw.write(find(nums, start, end)+ "\n");
            }

        }
        bw.flush();
        bw.close();
    }
    private static long find(long[] arr, int start, int end) {
        long sum = 0;
        while (end >= start) {
            if (start % 2 == 1) sum += arr[start];
            if (end % 2 == 0) sum += arr[end];
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return sum;
    }
    private static void update(long[] arr, int beforeIndex, long after, int k) {
        int num = beforeIndex + (int)Math.pow(2, k) - 1;
        arr[num] = after;
        while (num > 1) {
            num /= 2; // 부모 노드로 이동
            arr[num] = arr[num * 2] + arr[num * 2 + 1]; // 부모 노드 값 갱신
        }
    }
}