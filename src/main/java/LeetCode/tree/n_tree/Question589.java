package LeetCode.tree.n_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/6 18:49
 */

/**
 * 题目描述：给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 *
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 *
 * 提示：
 * 节点总数在范围 [0, 104]内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 */
public class Question589 {
    public static void main(String[] args) {
        Question589 question589 = new Question589();
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
        List<Integer> ans = question589.preorder(root);
        System.out.println(ans);
    }
    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();
    void traverse(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node node : root.children) {
            traverse(node);
        }
    }


}
