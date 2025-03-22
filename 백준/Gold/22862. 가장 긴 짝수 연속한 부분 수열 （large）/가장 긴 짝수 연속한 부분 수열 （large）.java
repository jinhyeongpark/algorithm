import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = 0; //현재 윈도우 내에 포함된 홀수 수
        int result = 0; //조건에서 남을 수 있는 연속 짝수의 최대 수

        while (right < N) {
            if (count > K) { //홀수 카운트가 K보다 많은 경우
                if (arr[left] % 2 == 1) count--;
                left++; //우로 이동
                //확장이 아닌 경우는 result를 갱신하지 않는다
                //확장 대상이 홀수이면 count를 소비하지 않고 늘릴 수 있기 때문이다
            } else { //count <= K
                if(arr[right] % 2 == 1) count++; //홀수의 경우 카운트를 올리고
                right++; //우로 이동
                //right - left는 현재 윈도우의 길이
                //count를 빼면 실제로 남는 짝수 수를 알 수 있다
                result = Math.max(result, right-left-count);
            }
        }
        System.out.println(result);
    }
}