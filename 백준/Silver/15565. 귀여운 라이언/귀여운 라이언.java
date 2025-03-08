import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //인형의 총 개수
        int K = Integer.parseInt(st.nextToken()); //최소 라이언(1) 수

        String[] nums = br.readLine().split(" ");
        List<Integer> indexOfOne = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(nums[i]) == 1) {
                indexOfOne.add(i);
            }
        }

        if (indexOfOne.size() < K) {
            System.out.println(-1);
        } else {
            int left = 0;
            int right = K-1;
            int length = indexOfOne.get(right) - indexOfOne.get(left) +1;
            while (right < indexOfOne.size()-1) {
                left++; right++;
                if (indexOfOne.get(right) - indexOfOne.get(left) +1 < length) {
                    length = indexOfOne.get(right) - indexOfOne.get(left) +1;
                }

            }
            System.out.println(length);
        }
    }
}