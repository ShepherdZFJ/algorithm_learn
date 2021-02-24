package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/23 18:32
 */
public class TestCase {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = null;
        for (int i = 1; i < nums.length; i++) {
            insert(root, nums[i]);
        }
        layerOrder(root);

    }


    // 二叉查找树的插入
    static void insert(TreeNode root, int x) {
        if (root == null) {
            root = new TreeNode(x);
            return;
        }
        if ( x == root.val) {
            return;
        }
        if (x > root.val) {
            insert(root.right, x);
        }
        if (x < root.val) {
            insert(root.left, x);
        }
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
