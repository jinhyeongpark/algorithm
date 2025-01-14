import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] pc;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        pc = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            pc[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pc[a].add(b);
            pc[b].add(a);
        }

        visited[1] = true;
        bfs(1);


        System.out.println(cnt);
    }
    private static void bfs(int num) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int n : pc[now]) {
                if (!visited[n]) {
                    cnt++;
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}