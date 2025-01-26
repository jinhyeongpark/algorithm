import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);

        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        D = new int[N+1];

        for (int i = 0; i < M; i++) {
            nums = br.readLine().split(" ");
            int start = Integer.parseInt(nums[0]);
            int end = Integer.parseInt(nums[1]);
            graph[start].add(end);
            D[end]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) pq.add(i);
        }
        while (!pq.isEmpty()) {
            int now = pq.poll();
            bw.write(now + " ");

            for (int next : graph[now]) {
                D[next]--;
                if (D[next] == 0) pq.add(next);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}