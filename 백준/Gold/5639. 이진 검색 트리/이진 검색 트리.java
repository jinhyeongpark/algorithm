import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int num; //노드 값
        Node left, right; //좌우 노드

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.num) { //현재 노드보다 작으면 왼쪽
                if (this.left == null) //현재 노드의 왼쪽이 비어있으면
                    this.left = new Node(n); //왼쪽에 삽입
                else this.left.insert(n); //비어있지 않으면 왼쪽 노드 기준으로 insert() 재귀
            } else { //현재 노드보다 크면 오른쪽
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine())); //첫 입력은 루트 노드
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) //공백 입력 전까지 반복
                break;
            root.insert(Integer.parseInt(input)); //전위 순회 순서대로 삽입하면 트리가 만들어짐
        }

        postOrder(root); //후위 순회 출력
    }

    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}