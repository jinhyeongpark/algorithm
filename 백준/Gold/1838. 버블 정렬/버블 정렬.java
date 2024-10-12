import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list.add(new int[]{i, Integer.parseInt(inputs[i])});
        }

        // 원본 리스트의 복사본 생성
        ArrayList<int[]> sortedList = new ArrayList<>(list);
        // 값 기준으로 정렬
        sortedList.sort(Comparator.comparingInt(o -> o[1]));

        int maxDisplacement = 0;

        for (int i = 0; i < N; i++) {
            // 이동 거리 계산: 원래 인덱스 - 정렬 후 인덱스
            int displacement = sortedList.get(i)[0] - i;
            // 최대 이동 거리 갱신
            if (displacement > maxDisplacement) {
                maxDisplacement = displacement;
            }
        }

        // 최소 패스 횟수는 최대 이동 거리
        System.out.println(maxDisplacement);
    }
}