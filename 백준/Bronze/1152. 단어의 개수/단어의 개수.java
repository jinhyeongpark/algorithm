import java.util.Scanner;

public class Main {
    //단어의 개수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine(); //문장을 한 줄로 입력받기
        sc.close();
        if (sentence.equals(" ")) System.out.println(0); //공백일 경우 0 출력
        else {
            sentence = sentence.trim(); //앞 뒤 공백 제거
            String words[] = sentence.split(" "); //공백 기준으로 나눠 배열에 저장
            System.out.println(words.length); //배열 길이 출력
        }
    }
}