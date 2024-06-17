import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);
        int res = 0;

        List<String> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            al.add(br.readLine());
        }
        for (int j = 0; j < M; j++) {
            String word = br.readLine();
            if (al.contains(word)) res++;
        }
        System.out.println(res);
    }

}