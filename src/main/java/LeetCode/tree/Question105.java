package LeetCode.tree;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/22 15:28
 */

import LeetCode.tree.TreeNode;

/**
 * 题目描述：根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class Question105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        postOrder(root);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = create(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
        return root;

    }
    public static TreeNode create(int preL, int preR, int inL, int inR, int[] preorder, int[] inorder) {
        if (preL > preR) {
            // 此时前序序列长度小于0，说明已经递归完成，直接返回
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[preL];
        int k;  //根据前序第一个是根节点特性，去查找中序中根节点的位置(注意:系列中的元素是不重复的)，
                // 这样就能找到左右子树了
        for (k = inL; k <= inR; k++) {
            if (inorder[k] == preorder[preL]) {
                break;
            }
        }
        int numLeft = k - inL;  //左子树的个数
        //左子树递归：左子树的前序区间为[preL+1, preL+numLeft], 中序区间为[inL, k-1]
        root.left = create(preL+1, preL+numLeft, inL, k-1,  preorder,  inorder);
        //右子树递归：右子树的前序区间为[preL+numLeft+1, preR], 中序区间为[k+1, inR]
        root.right = create(preL+numLeft+1, preR, k+1, inR, preorder, inorder);
        return root;
    }

    //前序遍历二叉树
    static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
