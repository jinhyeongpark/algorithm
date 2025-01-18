import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(""); // 입력받은 문자열을 문자 배열로 분리
        int res = 0; // 결과 값
        boolean isSubtraction = false; // 뺄셈 상태인지 여부
        StringBuilder temp = new StringBuilder(); // 숫자를 임시로 저장할 StringBuilder

        for (int i = 0; i < str.length; i++) {
            char s = str[i].charAt(0); // 현재 문자

            if (Character.isDigit(s)) {
                temp.append(s); // 숫자인 경우 temp에 추가
            } else {
                // 숫자가 끝났으면 처리
                if (temp.length() > 0) {
                    int number = Integer.parseInt(temp.toString());
                    res += isSubtraction ? -number : number; // 상태에 따라 더하거나 뺌
                    temp.setLength(0); // StringBuilder 비우기
                }

                // `-`를 만나면 이후 모든 숫자를 뺄셈 처리
                if (s == '-') {
                    isSubtraction = true;
                }
            }
        }

        // 마지막 숫자 처리
        if (temp.length() > 0) {
            int number = Integer.parseInt(temp.toString());
            res += isSubtraction ? -number : number;
        }

        System.out.println(res);
    }
}