import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static char[][] map;
    //상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static int W = 0;
    static int B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(W + " " + B);
    }
    private static void bfs(int x, int y) {
        char flag = map[x][y]; //탐색하는 첫 번째 병사
        int count = 0; //카운트

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int xLoc = now[0] + dx[i];
                int yLoc = now[1] + dy[i];

                if (xLoc >= 0 && yLoc >= 0 && xLoc < M && yLoc < N && !visited[xLoc][yLoc] && map[xLoc][yLoc] == flag) {
                    queue.add(new int[]{xLoc, yLoc});
                    visited[xLoc][yLoc] = true;
                }
            }
        }
        if (flag == 'W') {
            W += count * count;
        } else {
            B += count * count;
        }
    }
}