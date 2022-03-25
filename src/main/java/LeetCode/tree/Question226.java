package LeetCode.tree;

import LeetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/22 18:29
 */

/**
 * 题目描述：给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Question226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        TreeNode treeNode = invertTree(root);
        layerOrder(treeNode);

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode();
        convert(root, node);
        return node;

    }

    public static void convert(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        node.val = root.val;
        if (root.right != null) {
            if (node.left == null ) {
                node.left = new TreeNode();
            } else {
                node.left.val = root.right.val;
            }
        }

        if (root.left != null) {
            if (node.right == null ) {
                node.right = new TreeNode();
            } else {
                node.right.val = root.left.val;
            }
        }

        convert(root.left, node.right);
        convert(root.right, node.left);

    }

    //解法二：递归 将整棵树的节点翻转
    TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
       // root 节点需要交换它的左右⼦节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 让左右⼦节点继续翻转它们的⼦节点
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

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
