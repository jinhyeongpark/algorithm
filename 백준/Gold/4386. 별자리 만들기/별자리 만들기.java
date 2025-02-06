import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node> edges;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        double weight;

        public Node(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static double[][] points;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        points = new double[N][2];
        edges = new ArrayList<>();

        //좌표 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double weight = Math.sqrt(
                    Math.pow(points[i][0] - points[j][0], 2) +
                        Math.pow(points[i][1] - points[j][1], 2));
                edges.add(new Node(i, j, weight));
            }
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        Collections.sort(edges);

        int count = 0;
        double result = 0;

        //간선을 하나씩 선택
        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).start;
            int b = edges.get(i).end;
            double w = edges.get(i).weight;

            //사이클이 발생하지 않으면 간선 선택
            if (find(a) != find(b)) {
                union(a, b);
                result += w;
                count++;
                if (count == N - 1) {  
                    break;
                }
            }
        }


        System.out.printf("%.2f", result);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}
