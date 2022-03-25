package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/25 16:17
 */

/**
 * 题目描述：给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 *
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class Question114 {
    public static void main(String[] args) {
        Question114 question114 = new Question114();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        question114.flatten(root);
        System.out.println(root);
    }

    /**
     * 解题思路，先先序遍历得到values集合，再根据这个集合构造一个线性链表
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root);
        root.left = null;
        int k = 1;
        TreeNode node = null;
        TreeNode temp = null;
        while (k < values.size()) {

            if (temp == null) {
                temp = node = new TreeNode(values.get(k));
            } else {
                node.right = new TreeNode(values.get(k));
                node = node.right;
            }
            k++;
        }
        root.right = temp;
    }

    List<Integer> values = new ArrayList<>();
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
