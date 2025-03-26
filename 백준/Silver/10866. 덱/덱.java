import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken(); //명령
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken()); //값
            }

            if (order.equals("push_front")) {
                deque.addFirst(num);
            } else if (order.equals("push_back")) {
                deque.addLast(num);
            } else if (order.equals("pop_front")) {
                if (deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.pollFirst() + "\n");
                }
            } else if (order.equals("pop_back")) {
                if (deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.pollLast() + "\n");
                }
            } else if (order.equals("size")) {
                bw.write(deque.size() + "\n");
            } else if (order.equals("empty")) {
                bw.write((deque.isEmpty()? "1" : "0") + "\n");
            } else if (order.equals("front")) {
                if (deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.getFirst() + "\n");
                }
            } else {
                if (deque.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(deque.getLast() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}