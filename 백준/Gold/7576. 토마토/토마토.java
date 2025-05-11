import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;

    static Queue<tomato> queue = new LinkedList<>();

    static class tomato {
        int x, y, day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new tomato(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        System.out.println(bfs());
    }
    private static int bfs() {
        int maxDay = 0;

        while (!queue.isEmpty()) {
            tomato t = queue.poll();
            maxDay = Math.max(maxDay, t.day);

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && box[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        box[nx][ny] = 1;
                        queue.add(new tomato(nx, ny, t.day + 1));
                    }
                }
            }
        }
        // 안 익은 토마토가 있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) return -1; // 아직 익지 않은 토마토가 있다면
            }
        }
        return maxDay;
    }
}