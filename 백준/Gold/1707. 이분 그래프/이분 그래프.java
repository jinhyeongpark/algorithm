import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 그래프 초기화
            graph = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;

            // 간선 정보 입력
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            // 비연결 그래프의 모든 컴포넌트 처리
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    dfs(i, 0); // 시작 정점 색칠 (0으로 시작)
                }
            }

            // 결과 출력
            if (isEven) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int node, int color) {
        visited[node] = true;
        check[node] = color; // 현재 정점 색칠

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, 1 - color); // 인접 정점은 다른 색으로
            } else if (check[node] == check[next]) {
                isEven = false; // 인접 정점과 같은 색이면 이분 그래프 아님
            }
        }
    }
}
