import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> arr = new PriorityQueue<>((o1, o2) -> {
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);
            if (num1 == num2) return o1 > o2 ? 1 : -1; //절댓값이 같은 경우 음수 우선
            return num1 - num2;}); //절댓값이 작은 데이터 우선
        //PriorityQueue<Integer> arr = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                arr.add(num);
            } else {
                if (arr.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(arr.poll());
                }
            }
        }

    }
}