import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[] jumps;
    static int[] dir = {-1, 1};
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        jumps = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            jumps[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine()) - 1;

        bfs(start);
        System.out.println(cnt);
    }
    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N];

        queue.add(n);
        visited[n] = true;
        cnt = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int jump = jumps[now];

            for (int i = 0; i < 2; i++) {
                int next = now + dir[i] * jump;
                if (next >= 0 && next < N && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }
    }
}