package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/29 17:10
 */

/**
 * 题目描述：给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 示例 2：
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *
 *
 * 提示：
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 */
public class Question129 {
    public static void main(String[] args) {
        Question129 question129 = new Question129();
//        TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        TreeNode root = new TreeNode(1, null, new TreeNode(5));
        int i = question129.sumNumbers(root);
        System.out.println(i);
    }
    public int sumNumbers(TreeNode root) {
        preOrder(root, new StringBuilder());
        return values.stream().mapToInt(Integer::intValue).sum();
    }

    List<Integer> values = new ArrayList<>();

    void preOrder(TreeNode root, StringBuilder sb) {
        // 追加数组
        sb.append(root.val);
        // 如果没有子节点了，就返回当前叶子节点值
        if (root.left == null && root.right == null) {
            values.add(Integer.valueOf(sb.toString()));
            return;
        }
        // 遍历左节点，添加之后要删除，回溯
        if (root.left != null) {
            preOrder(root.left, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        // 遍历右节点，添加之后要删除，回溯
        if (root.right != null) {
            preOrder(root.right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
