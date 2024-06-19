import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            String xy[] = (br.readLine()).split(" ");
            int distance = Integer.parseInt(xy[1])-Integer.parseInt(xy[0]);
            int ans = 0;
            int min = 1;
            while (distance > 0) {
                distance -= min;
                ans += 1;
                if (ans % 2 == 0) {
                    min += 1;
                }
            } ansList.add(ans);
        }
        for (int e : ansList) {
            System.out.println(e);
        }
    }
}