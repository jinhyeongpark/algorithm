import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }


    static ArrayList<Node> tree;
    static int[] parent;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); //정점의 수
        int E = Integer.parseInt(st.nextToken()); //간선의 수

        tree = new ArrayList<>();
        parent = new int[V+1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.add(new Node(start, end, weight));
        }
        Collections.sort(tree);

        int count = 0; //선택된 간선의 수
        for (int i = 0; i < E; i++) {
            int start = tree.get(i).start;
            int end = tree.get(i).end;
            int weight = tree.get(i).weight;
            if (find(start) != find(end)) {
                union(start, end);
                result += weight;
                count++;
                if (count == V - 1) { //MST가 완성되면 반복 종료
                    break;
                }
            }
        }
        System.out.println(result);
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