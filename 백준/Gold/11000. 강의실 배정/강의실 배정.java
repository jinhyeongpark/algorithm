import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] start = new int[N];
        int[] end = new int[N];

        // 시작 시간과 종료 시간을 분리하여 저장
        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            start[i] = Integer.parseInt(nums[0]); // 시작 시간
            end[i] = Integer.parseInt(nums[1]);  // 종료 시간
        }

        // 시작 시간과 종료 시간 정렬
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;  // 현재 필요한 회의실 개수
        int maxRooms = 0; // 최소 회의실 개수
        int i = 0, j = 0;

        // 두 포인터로 겹치는 회의 개수 계산
        while (i < N && j < N) {
            if (start[i] < end[j]) {
                rooms++; // 새로운 회의 시작, 회의실 추가 필요
                maxRooms = Math.max(maxRooms, rooms); // 최대 회의실 개수 갱신
                i++;
            } else {
                rooms--; // 종료된 회의, 회의실 반환 가능
                j++;
            }
        }

        System.out.println(maxRooms); // 최소 회의실 개수 출력
    }
}
