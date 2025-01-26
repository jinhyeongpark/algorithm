import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] check; // 방문 여부 및 색깔 (-1, 1: 색, 0: 방문 안 함)
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for (int j = 0; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }
            check = new int[V+1];
            isEven = true;

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }

            for (int j = 1; j <= V; j++) {
                if (check[j] == 0) {
                    check[j] = 1;
                    dfs(j);
                }
            }
            if (isEven) bw.write("YES\n");
            else bw.write("NO\n");

        }
        bw.flush();
        bw.close();
    }
    private static void dfs(int node) { //dfs 메서드
        if (check[node] == 0) return;
        for (int next : graph[node]) { //인접 리스트에 대해서
            if (check[next] == 0) { //방문 여부 확인 후
                check[next] = -check[node];
                dfs(next); //dfs호출
            } else if (check[node] == check[next]){
                isEven = false;
                return;
            }
        }
    }
}