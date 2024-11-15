import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    //dx[0]은 x로 0만큼 y로 1만큼 이동을 의미
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited; //방문 배열
    static int[][] A; //A 배열
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M]; //A 배열 초기화
        visited = new boolean[N][M]; //방문 배열 초기화

        //A 배열에 데이터 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken(); //한 줄을 저장
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1)); //하나씩 저장
            }
        }
        bfs(0, 0);
        System.out.println(A[N-1][M-1]);
    }
    private static void bfs(int i, int j) {
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[] {i, j}); //큐에 (0, 0)을 삽입
        visited[i][j] = true; //방문 true
        while (!queue.isEmpty()) { //queue 가 빌 때 까지 탐색
            int[] now = queue.poll(); //queue에서 poll을 하며 인접(해당 문제에서는 상하좌우) 노드를 저장
            for (int k = 0; k < 4; k++) { //상, 우, 하, 좌 탐색
                int x = now[0] + dx[k]; //x
                int y = now[1] + dy[k]; //y
                //저장(방문)가능한 조건인지 탐색
                //배열을 벗어나지 않고
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    //값이 0이거나 방문한 노드가 아닌 곳
                    if (A[x][y] != 0 && !visited[x][y]) {
                        //방문 가능한 조건이면
                        visited[x][y] = true; //방문 true
                        A[x][y] = A[now[0]][now[1]] + 1; //해당 노드의 값을 깊이 값으로 변경한 후
                        queue.add(new int [] {x, y}); //큐에 삽입
                    }
                }
            }
        }
    }
}