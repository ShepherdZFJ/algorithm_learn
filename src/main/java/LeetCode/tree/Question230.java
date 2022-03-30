package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/30 17:19
 */

/**
 * 题目描述:给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 */
public class Question230 {
    public static void main(String[] args) {
        Question230 question230 = new Question230();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)),
                new TreeNode(8, new TreeNode(6), new TreeNode(9)));
        int i = question230.kthSmallest(root, 6);
        System.out.println(i);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return values.get(k-1);
    }
    List<Integer> values = new ArrayList<>();
    // BST的中序遍历是严格有序的
    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }
}
