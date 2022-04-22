package LeetCode.tree;

import LeetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/22 16:09
 */

/**
 * 题目描述：给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗 二叉树 。
 *
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 */
public class Question106 {
    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(inorder, postorder);
        //preOrder(root);
        layerOrder(root);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = create(0, postorder.length-1, 0, inorder.length-1, postorder, inorder);
        return root;

    }
    public static TreeNode create(int postL, int postR, int inL, int inR, int[] postorder, int[] inorder) {
        if (postL> postR) {
            // 此时后序序列长度小于0，说明已经递归完成，直接返回
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = postorder[postR];
        int k;  //根据后序最后一个是根节点特性，去查找中序中根节点的位置(注意:系列中的元素是不重复的)，
        // 这样就能找到左右子树了
        for (k = inL; k <= inR; k++) {
            if (inorder[k] == postorder[postR]) {
                break;
            }
        }
        int numLeft = k - inL;  //左子树的个数
        //左子树递归：左子树的后序区间为[postL, postL+numLeft-1], 中序区间为[inL, k-1]
        root.left = create(postL, postL+numLeft-1, inL, k-1,  postorder,  inorder);
        //右子树递归：右子树的后序区间为[postL+numLeft, postR], 中序区间为[k+1, inR]
        root.right = create(postL+numLeft, postR-1, k+1, inR, postorder, inorder);
        return root;
    }

    //前序遍历二叉树
    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 层序遍历
    static void layerOrder(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (! list.isEmpty()) {
            TreeNode node = list.get(0);
            list.remove(0);
            System.out.print(node.val + " ");
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }
}
