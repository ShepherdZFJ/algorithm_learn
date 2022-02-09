package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 10:23
 */
public class Question110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, new TreeNode(1, null, null), null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, new TreeNode(10, null, null), null)));
        Question110 question110 = new Question110();
        boolean b = question110.isBalanced(root);
        System.out.println(b);
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight;
    }
}
