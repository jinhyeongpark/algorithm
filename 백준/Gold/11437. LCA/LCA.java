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
    static int[] parent;     // 바로 부모 정보
    static int[] depth;      // 각 노드의 깊이 (루트의 깊이는 1)
    static boolean[] visited;
    static int[][] dp;       // dp[k][v] : v의 2^k번째 부모
    static int N, LOG;

    public static void main(String[] args) throws IOException {
        // 입력 및 출력 스트림 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 노드의 개수 N 입력
        N = Integer.parseInt(br.readLine());

        // 트리(인접 리스트) 초기화
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        // 간선 정보 입력 (양방향)
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // BFS를 통해 각 노드의 깊이와 바로 부모 정보를 계산 (루트: 1번)
        bfs();

        // dp 테이블의 행 수(LOG)를 결정  
        // LOG는 2^LOG가 N보다 크거나 같은 최소의 값
        LOG = 0;
        while ((int) Math.pow(2, LOG) <= N) {
            LOG++;
        }

        // dp 테이블 초기화
        dp = new int[LOG][N + 1];
        // dp[0][v]는 v의 바로 부모 정보
        for (int i = 1; i <= N; i++) {
            dp[0][i] = parent[i];
        }

        // 점화식 : dp[k][v] = dp[k-1][ dp[k-1][v] ]
        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= N; v++) {
                int mid = dp[k - 1][v];
                if (mid != 0) {
                    dp[k][v] = dp[k - 1][mid];
                } else {
                    dp[k][v] = 0;
                }
            }
        }

        // LCA 쿼리 처리
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(lca(a, b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // BFS를 이용하여 각 노드의 깊이와 바로 부모 정보를 계산하는 함수
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        depth[1] = 1;   // 루트 노드의 깊이는 1
        parent[1] = 0;  // 루트의 부모는 0으로 처리

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : tree[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    parent[nxt] = cur;
                    depth[nxt] = depth[cur] + 1;
                    queue.add(nxt);
                }
            }
        }
    }

    // 점화식(dp 테이블)을 활용한 Binary Lifting 기법의 LCA 함수
    // 비트연산 없이 Math.pow()를 이용해 2의 거듭제곱 값을 계산합니다.
    static int lca(int a, int b) {
        // a가 더 깊은 노드가 되도록 swap
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // a와 b의 깊이 차이를 맞춤 (a를 위로 올림)
        for (int k = LOG - 1; k >= 0; k--) {
            // 2^k 칸 만큼의 jump 값을 계산 (비트연산 대신 Math.pow 사용)
            int jump = (int) Math.pow(2, k);
            if (depth[a] - jump >= depth[b]) {
                a = dp[k][a];
            }
        }

        // 깊이를 맞춘 후 두 노드가 같으면 LCA 반환
        if (a == b) {
            return a;
        }

        // 두 노드를 동시에 위로 올리면서 LCA의 바로 아래 단계까지 접근
        for (int k = LOG - 1; k >= 0; k--) {
            if (dp[k][a] != dp[k][b]) {
                a = dp[k][a];
                b = dp[k][b];
            }
        }

        // 마지막 한 번 올리면 LCA에 도달 (또는 dp[0][a]를 반환)
        return parent[a];
    }
}
