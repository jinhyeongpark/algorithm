import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visitied; //방문 배열
    static ArrayList<Integer>[] A; //인접 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visitied = new boolean[N+1]; //방문 배열 초기화
        A = new ArrayList[N+1]; //인접 리스트

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<Integer>(); //각 배열에 ArrayList를 넣어주는 초기화
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //시작점
            int e = Integer.parseInt(st.nextToken()); //종료점
            //무방향이므로 s도 e를 가지고 e도 s를 가짐
            A[s].add(e);
            A[e].add(s);
        }
        //dfs 호출 횟수
        int cnt = 0;

        for (int i = 1; i < N+1; i++) { //연결 요소 카운트
            if (!visitied[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt); //연결 요소 수
    }
    private static void dfs(int v) { //dfs 메서드
        if (visitied[v]) return;
        visitied[v] = true;
        for (int i : A[v]) {
            if (!visitied[i]) {
                dfs(i);
            }
        }
    }
}