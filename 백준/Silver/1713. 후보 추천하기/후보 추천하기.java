import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Student {
        int id;
        int recommended;
        int order;

        Student(int id, int order) {
            this.id = id;
            this.recommended = 0;
            this.order = order;
        }
        void recommend() {
            this.recommended++;
        }
    }

    static ArrayList<Student> students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        students = new ArrayList<>();

        int numOfRecommendation = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numOfRecommendation; i++) {
            int studentId = Integer.parseInt(st.nextToken());
            // 이미 등록된 학생이면 추천 수 증가
            if (isRegistered(studentId)) {
                getStudent(studentId).recommend();
            } else { // 그렇지 않으면 틀의 수가 초과되었는지 확인
                if (students.size() < N) { // 초과되지 않았다면 등록 후 추천 수 증가
                    Student student = new Student(studentId,i);
                    student.recommend();
                    students.add(student);
                } else { // 초과되었다면 가장 낮은 추천 수의 학생을 제거하고 새로 등록 후 추천 수 증가
                    Collections.sort(students, (s1, s2) -> {
                        if (s1.recommended == s2.recommended) return s1.order - s2.order;
                        return s1.recommended - s2.recommended;
                    });
                    students.remove(0);
                    Student newStudent = new Student(studentId, i);
                    newStudent.recommend();
                    students.add(newStudent);
                }
            }
        }
        ArrayList<Integer> ids = new ArrayList<>();
        for (Student student : students) {
            ids.add(student.id);
        }
        Collections.sort(ids);
        for (int id : ids) {
            System.out.print(id + " ");
        }
    }

    private static boolean isRegistered(int id) {
        for (Student student : students) {
            if (student.id == id) return true;
        }
        return false;
    }

    private static Student getStudent(int id) {
        for (Student student : students) {
            if (student.id == id) return student;
        }
        return null;
    }
}
