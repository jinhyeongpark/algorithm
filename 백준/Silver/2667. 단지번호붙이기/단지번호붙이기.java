import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static int[][] map;
    //상, 우, 하, 좌 탐색
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer> result;
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine()); //정사각 그래프의 한 변 길이
        //전역 변수 초기화
        visited = new boolean[N][N];
        map = new int[N][N];
        result = new ArrayList<>();
        cnt = 1;
        //map 구성
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        //dfs
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited[x][y] && map[x][y] == 1) {
                    dfs(x, y);
                    result.add(cnt);
                    cnt = 1;
                }
            }
        }
        Collections.sort(result);
        bw.write(result.size() + "\n");
        for (int n : result) {
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();

    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xLoc = dx[i] + x;
            int yLoc = dy[i] + y;

            if ( xLoc >= 0 && yLoc >= 0 && xLoc < N && yLoc < N && !visited[xLoc][yLoc] && map[xLoc][yLoc] == 1) {
                cnt++;
                dfs(xLoc, yLoc);
            }
        }
    }
}