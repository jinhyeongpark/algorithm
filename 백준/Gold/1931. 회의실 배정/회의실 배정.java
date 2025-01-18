import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end; // end 기준 오름차순 정렬
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Arrays.sort(meetings);

        int cnt = 1;
        int lastEnd = meetings[0].end;

        for (int i = 1; i < N; i++) {
            if (lastEnd <= meetings[i].start) {
                cnt++;
                lastEnd = meetings[i].end;
            }
        }
        System.out.println(cnt);
    }
}