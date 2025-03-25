import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //큐의 크기
        int M = Integer.parseInt(st.nextToken()); //뽑으려는 수의 개수

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] targets = new int[M];
        for (int i = 0 ; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int target : targets) {
            int index = 0;
            for (int num : deque) {
                if (num == target) break;
                index++;
            }

            if (index <= deque.size() / 2) { //앞쪽에 있으면
                while (deque.peek() != target) { //반환
                    deque.offerLast(deque.pollFirst()); //좌로 이동
                    cnt++;
                }
            }
            else { //뒷쪽에 있으면
                while (deque.peek() != target) { //반환
                    deque.offerFirst(deque.pollLast()); //우로 이동
                    cnt++;
                }
            }
            deque.poll(); //삭제 연산
        }
        System.out.println(cnt);
    }
}