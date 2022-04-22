package LeetCode.tree.n_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/6 18:31
 */

/**
 * 题目描述：给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 *
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 *
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 *
 *
 * 提示：
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 104] 之间。
 */
public class Question559 {
    public static void main(String[] args) {
        Question559 question559 = new Question559();
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
        int ans = question559.maxDepth(root);
        System.out.println(ans);
    }

    public int maxDepth(Node root) {
        traverse(root);
        return res;
    }

    int depth = 0;
    int res = 0;
    void traverse(Node root) {
        if (root == null) {
            return;
        }
        depth++;
        res = Math.max(res, depth);
        if (root.children == null) {
            return;
        }
        for (Node node : root.children) {
            traverse(node);
            depth--;
        }

    }


}
