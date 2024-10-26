import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value; //노드의 고유 번호
    TreeNode parent; //부모 노드
    List<TreeNode> children; //자식노트 저장 리스트

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
        this.parent = null;
    }

    public void addChild(TreeNode child) {
        child.parent = this;
        this.children.add(child);
    }
    public void removeChild(TreeNode child) {
        this.children.remove(child);
    }
    public boolean isLeaf() {
        return children.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //트리의 노드 개수
        TreeNode[] nodes = new TreeNode[N];
        int root = -1;

        // 트리 노드 초기화
        for (int i = 0; i < N; i++) {
            nodes[i] = new TreeNode(i);
        }

        // 부모 배열 입력 및 트리 구성
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int parentIndex = Integer.parseInt(input[i]);
            if (parentIndex == -1) {
                root = i; //루트 노드 설정
            } else {
                nodes[parentIndex].addChild(nodes[i]); //부모자식 관계 설정
            }
        }

        int deleteNode = Integer.parseInt(br.readLine()); //삭제할 노드 번호

        // 노드 삭제 및 리프 노드 개수 계산
        int leafCount = countLeafNodesAfterDeletion(nodes, root, deleteNode);
        System.out.println(leafCount);
    }

    //노드를 삭제한 후 리프 노드의 개수를 계산하는 메서드
    private static int countLeafNodesAfterDeletion(TreeNode[] nodes, int root, int deleteNode) {
        if (root == deleteNode) {
            return 0; //루트를 삭제하면 리프 노드 개수는 0
        }

        //삭제된 노드와 그 자손들을 트리에서 제거
        deleteSubtree(nodes[deleteNode]);

        //리프 노드 개수 계산
        return countLeafNodes(nodes[root]);
    }

    // 특정 노드와 그 자손을 트리에서 제거하는 메서드
    private static void deleteSubtree(TreeNode node) {
        if (node == null) return;
        if (node.parent != null) {
            node.parent.removeChild(node); //부모 노드에서 자신 제거
        }
        //자식 노드들에 대해 재귀적으로 삭제
        for (TreeNode child : node.children) {
            deleteSubtree(child);
        }
    }

    //리프 노드의 개수를 재귀적으로 계산
    private static int countLeafNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.isLeaf()) {
            return 1; // 자식이 없는 경우 리프 노드
        }

        int leafCount = 0;
        for (TreeNode child : node.children) {
            leafCount += countLeafNodes(child);
        }
        return leafCount;
    }
}