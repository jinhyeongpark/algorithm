import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //데이터 수
        int M = Integer.parseInt(st.nextToken()); //질의 수

        int k = (int)(Math.ceil(Math.log(N)/Math.log(2))); //k값

        int treeSize = (int)Math.pow(2, k+1); //트리 크기
        int leafStart = (int)Math.pow(2, k); //데이터 시작 인덱스

        minTree = new int[treeSize + 1];
        maxTree = new int[treeSize + 1];

        //리프노드 초기화
        for (int i = leafStart; i < leafStart + N; i++) {
            int num = Integer.parseInt(br.readLine());
            minTree[i] = num;
            maxTree[i] = num;
        }
        for (int i = leafStart-1; i > 0; i--) {
            minTree[i] = Math.min(minTree[2*i], minTree[2*i+1]);
            maxTree[i] = Math.max(maxTree[2*i], maxTree[2*i+1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) + leafStart-1;
            int end = Integer.parseInt(st.nextToken()) + leafStart-1;
            bw.write(findMin(start, end) + " ");
            bw.write(findMax(start, end) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
    private static int findMin(int start, int end) {
        int res = 1000000000;
        while (end >= start) {
            if (start % 2 == 1) res = Math.min(res, (minTree[start]));
            if (end % 2 == 0) res = Math.min(res, (minTree[end]));
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return res;
    }
    private static int findMax(int start, int end) {
        int res = 0;
        while (end >= start) {
            if (start % 2 == 1) res = Math.max(res, (maxTree[start]));
            if (end % 2 == 0) res = Math.max(res, (maxTree[end]));
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return res;
    }
}