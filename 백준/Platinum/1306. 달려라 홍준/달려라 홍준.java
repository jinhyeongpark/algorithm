import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 코스의 길이
        int M = Integer.parseInt(st.nextToken()); // 시야의 범위

        int size = M*2 - 1;
        //2^k >= 5
        int k = (int)Math.ceil((Math.log(N)/Math.log(2)));

        int treeSize = (int)Math.pow(2,k) * 2; //세그먼트 트리 크기
        int leaf_start = (int)Math.pow(2, k); //리프노드 시작 인덱스

        int tree[] = new int [treeSize + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = leaf_start; i < leaf_start + N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = leaf_start - 1; i > 0; i--) {
            tree[i] = Math.max(tree[2*i], tree[2*i+1]);
        }

        for (int i = 0; i <= N - size; i++) {
            int start = leaf_start + i;
            int end = start + size - 1;
            bw.write(find(tree, start, end) + " ");
        }
        bw.flush();
        bw.close();
    }
    private static long find(int[] tree, int start, int end) {
        int res = 0;
        while (end >= start) {
            if (start % 2 == 1) res = Math.max(res, (tree[start]));
            if (end % 2 == 0) res = Math.max(res, (tree[end]));
            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }
        return res;
    }
}