import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph; // 그래프를 인접 리스트로 표현
    static int[] check; // -1: 방문 안 함, 0: 색깔 0, 1: 색깔 1
    static boolean isEven; // 이분 그래프 여부를 나타내는 플래그

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점 수
            int E = Integer.parseInt(st.nextToken()); // 간선 수

            // 그래프 초기화
            graph = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            check = new int[V + 1];
            Arrays.fill(check, -1); // -1로 초기화 (아직 방문하지 않음)
            isEven = true;

            // 간선 정보 입력
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            // 비연결 그래프 처리
            for (int i = 1; i <= V; i++) {
                if (check[i] == -1 && isEven) { // 방문하지 않은 정점에서 DFS 시작
                    dfs(i);
                }
            }

            // 결과 저장
            if (isEven) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        bw.write(sb.toString()); // 최종 결과 출력
        bw.flush();
        bw.close();
    }

    private static void dfs(int node) {
        for (int next : graph[node]) { // 인접 정점 탐색
            if (check[next] == -1) { // 아직 방문하지 않은 정점
                check[next] = (check[node] + 1) % 2; // 현재 정점과 다른 색으로 색칠
                dfs(next); // 재귀 호출
            } else if (check[next] == check[node]) { // 인접 정점이 같은 색이면
                isEven = false; // 이분 그래프가 아님
                return; // 더 이상 탐색할 필요 없음
            }
        }
    }
}
