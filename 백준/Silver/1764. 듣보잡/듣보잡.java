import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+M; i++) {
            String word = br.readLine();
            if (set.contains(word)) list.add(word);
            set.add(word);
        }
        Collections.sort(list);
        System.out.println(N+M- set.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}