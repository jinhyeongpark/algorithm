import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);

        Map<Integer, String> indexToWord = new HashMap<>();
        Map<String, Integer> wordToIndex = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String word = br.readLine();
            indexToWord.put(i, word);
            wordToIndex.put(word, i);
        }

        // M개의 퀴즈 입력 처리
        for (int j = 0; j < M; j++) {
            String word = br.readLine();
            // 입력된 단어가 숫자인 경우
            if (Character.isDigit(word.charAt(0))) {
                int index = Integer.parseInt(word);
                System.out.println(indexToWord.get(index));
            } else {
                // 입력된 단어가 문자인 경우
                System.out.println(wordToIndex.get(word));
            }
        }
    }
}