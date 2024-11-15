import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f,s,g;
    static int[] move;
    static int[] dir = new int[2];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken()); //건물 높이
        s = Integer.parseInt(st.nextToken()); //강호의 위치
        g = Integer.parseInt(st.nextToken()); //회사의 층수
        dir[0] = Integer.parseInt(st.nextToken()); //위로 이동
        dir[1] = -Integer.parseInt(st.nextToken()); //아래로 이동

        move = new int[f+1]; //1층부터 시작하기 위함
        bfs(s);
    }
    private static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[f+1]; //방문한 층수

        queue.add(s);
        visited[s] = true;
        move[s] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if (now == g) {
                System.out.println(move[now]);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int next = now + dir[i];
                if (next >= 1 && next <= f && !visited[next]) {
                    visited[next] = true;
                    move[next] = move[now] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.println("use the stairs");
    }
}