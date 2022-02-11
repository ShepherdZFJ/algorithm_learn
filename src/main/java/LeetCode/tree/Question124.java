package LeetCode.tree;


import java.util.HashMap;
import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/11 15:12
 */

/**
 * 题目描述：路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class Question124 {

    public static void main(String[] args) {
        Question124 question124 = new Question124();
        TreeNode treeNode = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        question124.maxPathSum(treeNode);
        System.out.println(question124.ans);
    }


    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return ans;
    }

    // 遍历所有节点
    public void traverse(TreeNode root) {
        oneSideMax(root);
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }


    int oneSideMax(TreeNode root) {
        if (root == null) return 0;
        // 获取当前节点为起点连接左子树的节点的最大和，如果连接的左子树节点和小于0，那么说明连接左子树节点只会导致和变小，所以不连，赋值left=0
        int left = Math.max(0, oneSideMax(root.left));
        // 获取当前节点为起点连接右子树的节点的最大和，如果连接的右子树节点和小于0，那么说明连接右子树节点只会导致和变小，所以不连，right=0
        int right = Math.max(0, oneSideMax(root.right));
        // 比较当前节点路径最大和与之前记录的最大值
        ans = Math.max(ans, left + right + root.val);
        // 返回当前节点为起点的路径最大和
        return Math.max(left, right) + root.val;
    }
}
