package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/22 18:29
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
