package LeetCode.tree.n_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/6 18:57
 */
public class Question590 {
    public static void main(String[] args) {
        Question590 question590 = new Question590();
        Node node1 = new Node(3);
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(5));
        nodes.add(new Node(6));
        node1.children = nodes;

        List<Node>nodes1 = new ArrayList<>();
        nodes1.add(node1);
        nodes1.add(new Node(2));
        nodes1.add(new Node(4));

        Node root = new Node(1, nodes1);
        List<Integer> ans = question590.postorder(root);
        System.out.println(ans);
    }
    public List<Integer> postorder(Node root) {
        traverse(root);
        return res;

    }

    List<Integer> res = new ArrayList<>();
    void traverse(Node root) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                traverse(node);
            }
        }
        res.add(root.val);
    }

}
