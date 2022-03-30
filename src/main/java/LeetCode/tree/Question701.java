package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/30 16:26
 */
/**
 * 题目描述: 二插查找树插入
 */
public class Question701 {
    public static void main(String[] args) {
        Question701 question701 = new Question701();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));
        TreeNode treeNode = question701.insertIntoBST(root, 5);
        System.out.println(treeNode);
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

}
