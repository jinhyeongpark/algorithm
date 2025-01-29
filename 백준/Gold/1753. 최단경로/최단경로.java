import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 100_000_000;

    static class Node implements Comparable<Node> {
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static boolean[] visited;
    static int[] d;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); //정점의 수
        int E = Integer.parseInt(st.nextToken()); //간선의 수
        //정적 변수 초기화
        visited = new boolean[V+1];
        d = new int[V+1];
        Arrays.fill(d, INF);
        graph = new ArrayList[V+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        int K = Integer.parseInt(br.readLine()); //시작 정점
        d[K] = 0;

        for (int i = 0 ; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.next] = true;
            for (Node n : graph[now.next]) {
                if (!visited[n.next]) {
                    if (d[n.next] > d[now.next] + n.weight) {
                        d[n.next] = d[now.next] + n.weight;
                        queue.add(new Node(n.next, d[n.next]));
                    }
                }
            }
        }

        for (int i = 1; i < d.length; i++) {
            if (d[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }
    }
}