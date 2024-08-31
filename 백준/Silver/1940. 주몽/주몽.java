import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] strNums = br.readLine().split(" ");

        Set<Integer> compareSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            compareSet.add(M - Integer.parseInt(strNums[i]));
            //7 2 5 8 4 6
        }

        for (int i = 0; i < N; i++) {
            compareSet.add(Integer.parseInt(strNums[i]));
        }

        System.out.println((N*2-compareSet.size())/2);
    }
}