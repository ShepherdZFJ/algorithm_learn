package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 14:43
 */
public class Question112 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(1), null)));
        Question112 question112 = new Question112();
        boolean b = question112.hasPathSum(root, 22);
        System.out.println(b);

    }
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
         DFS(root, targetSum, 0);
        return result;
    }

    void DFS(TreeNode root, int targetSum, int sumValue) {
        if (root == null) {
            return ;
        }
        sumValue = sumValue + root.val;
        if (sumValue == targetSum && root.left == null && root.right == null) {
            result = true;
            return;
        }
        if (!result) {
            DFS(root.left, targetSum, sumValue);
            DFS(root.right, targetSum, sumValue);
        }
    }
}
