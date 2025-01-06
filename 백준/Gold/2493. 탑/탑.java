import java.io.*;
import java.util.*;

public class Main {

    static class Top {
        int index;
        int height;
        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Top> tops = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            Top top = new Top(i, Integer.parseInt(st.nextToken()));


            while (!tops.isEmpty()) {
                if (tops.peek().height > top.height) {
                    bw.write(tops.peek().index + " ");
                    break;
                }
                tops.pop();
            }
            if (tops.isEmpty()) { //첫 번째 탑이면
                bw.write("0 "); //0을 출력 후

            }
            tops.push(top); //스택에 추가
        }
        bw.flush();
        bw.close();
    }

}