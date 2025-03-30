import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class Result implements Comparable<Result> {
        int nation;
        int num;
        int score;

        public Result(int nation, int num, int score) {
            this.nation = nation;
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Result o) {
            return o.score - this.score; // 내림차순 정렬
        }

        public void print() {
            System.out.println(this.nation + " " + this.num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Result> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nation = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            results.add(new Result(nation, num, score));
        }
        Collections.sort(results);

        int maxWinners = 3;
        int cnt = 0;
        int idx = 0;
        // 국가별 당첨자 수를 관리하기 위한 HashMap 사용
        Map<Integer, Integer> nationCnt = new HashMap<>();

        while (cnt < maxWinners && idx < results.size()) {
            Result result = results.get(idx);
            int currentCount = nationCnt.getOrDefault(result.nation, 0);

            // 해당 국가의 당첨자 수가 2명 이상이면 다음 후보로 넘어감
            if (currentCount >= 2) {
                idx++;
                continue;
            }

            // 당첨자 수 업데이트 및 결과 출력
            nationCnt.put(result.nation, currentCount + 1);
            result.print();
            cnt++;
            idx++;
        }
    }
}