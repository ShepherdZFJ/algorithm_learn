package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/9 13:59
 */

/**
 * 题目描述：给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列
 *，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 * 示例 2:
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 */
public class Question116 {
    public static void main(String[] args) {
        Question116 question116 = new Question116();
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null), null);
        Node node = question116.connect(root);
        System.out.println(node);
    }

    /**
     * 层序遍历，同一层当前节点next为下一个节点
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (i < size-1) {
                    node.next = q.peek();
                } else {
                    node.next = null;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

        }
        return root;
    }



}
