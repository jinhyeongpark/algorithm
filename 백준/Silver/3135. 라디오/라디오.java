import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<>();
        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        if (nums.contains(B)) {
            System.out.println(1);
        } else {
            for(int i = 0; i < N; i++) {
                diff.add(Math.abs(B-nums.get(i))+1);
            }
            System.out.println(Math.min(Math.abs(B-A), Collections.min(diff)));
        }
    }
}