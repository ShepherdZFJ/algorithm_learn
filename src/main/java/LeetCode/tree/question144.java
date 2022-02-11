package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/11 17:56
 */

/**
 * 题目描述：给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class question144 {
    public static void main(String[] args) {
        question144 question144 = new question144();
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        question144.preorderTraversal(treeNode);
        System.out.println(question144.ans);
    }
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }
}
