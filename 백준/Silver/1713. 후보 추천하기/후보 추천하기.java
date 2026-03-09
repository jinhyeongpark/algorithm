import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Student implements Comparable<Student> {
        int id, recommended, order;

        Student(int id, int order) {
            this.id = id;
            this.recommended = 1; // 등록과 동시에 추천 1회
            this.order = order;
        }

        @Override
        public int compareTo(Student o) {
            int res = Integer.compare(this.recommended, o.recommended);
            if (res == 0) return Integer.compare(this.order, o.order);
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalRec = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Student> frames = new ArrayList<>();

        for (int i = 0; i < totalRec; i++) {
            int id = Integer.parseInt(st.nextToken());

            Student target = null;
            for (Student s: frames) {
                if (s.id == id) {
                    target = s;
                    break;
                }
            }

            if (target != null) {
                target.recommended++;
            } else {
                if (frames.size() == N) {
                    Collections.sort(frames);
                    frames.remove(0);
                }
                frames.add(new Student(id, i));
            }
        }
        Collections.sort(frames, (s1, s2) -> s1.id - s2.id);
        StringBuilder sb = new StringBuilder();
        for (Student s : frames) sb.append(s.id).append(" ");
        System.out.println(sb);
    }
}
