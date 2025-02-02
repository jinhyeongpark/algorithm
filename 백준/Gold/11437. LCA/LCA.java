import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] tree;

    static int[] parent;
    static int[] depth;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for (int i = 0 ; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        parent = new int[N+1];
        depth = new int[N+1];
        visited = new boolean[N+1];

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }
        bfs();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(lca(start, end) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        depth[1] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : tree[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    parent[next] = now;
                    depth[next] = depth[now] + 1;
                    visited[next] = true;
                }
            }
        }
    }
    static int lca(int a, int b) {

        if (depth[a] > depth[b]) {
            a = matchDepth(a, depth[a] - depth[b]);
        } else {
            b = matchDepth(b, depth[b] - depth[a]);
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    static int matchDepth(int x, int num) {
        for (int i = 0; i < num; i++) {
            x = parent[x];
        }
        return x;
    }
}