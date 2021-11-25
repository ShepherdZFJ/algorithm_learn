package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/25 15:22
 */

/**
 * 题目描述：二叉树的中序遍历
 */
public class Question94 {
    public static void main(String[] args) {
        Question94 question94 = new Question94();
        TreeNode treeNode = new TreeNode(3,new TreeNode(1, null, new TreeNode(2, null, null)),
                new TreeNode(4, null, new TreeNode(5, null, null)));
        List<Integer> list = question94.inorderTraversal(treeNode);
        System.out.println(list);

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}
