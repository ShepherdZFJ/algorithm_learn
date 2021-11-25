package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/24 16:15
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树；
 * 二叉搜索树：又称为二叉查找树、二叉排序树；
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Question98 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(2, null, null), new TreeNode(2, null, null));
        Question98 question98 = new Question98();
        boolean b = question98.isValidBST(treeNode);
        System.out.println(b);
    }



    /**
     *
     * @param root
     * @param leftNode
     * @param rightNode
     * @return
     */
    boolean isValidBST(TreeNode root, TreeNode leftNode, TreeNode rightNode) {
        if (root == null) return true;
        if (leftNode != null && root.val <= leftNode.val) return false;
        if (rightNode != null && root.val >= rightNode.val) return false;
        return isValidBST(root.left, leftNode, root)
                && isValidBST(root.right, root, rightNode);
    }


    /**
     * 解法二：二叉搜索树的中序遍历是一个有序的列表
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    break;
                }
                if (list.get(i) >= list.get(i+1)) {
                    return false;
                }
            }
            return true;
        }
        return false;
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
