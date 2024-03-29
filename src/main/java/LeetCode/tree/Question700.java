package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/30 16:13
 */

/**
 * 题目描述：给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * 示例 1:
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 *
 * Example 2:
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 *
 *
 * 提示：
 * 数中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 107
 * root 是二叉搜索树
 * 1 <= val <= 107
 */
public class Question700 {
    public static void main(String[] args) {
        Question700 question700 = new Question700();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)),
                new TreeNode(8, new TreeNode(6), new TreeNode(9)));
        TreeNode treeNode = question700.searchBST(root, 10);
        System.out.println(treeNode);

    }

    // 二叉搜索树查找
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else  {
           return searchBST(root.left, val);
        }
    }
}
