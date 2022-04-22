package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/29 16:03
 */

/**
 * 题目描述：给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * 如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 *
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *
 * 提示：
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 */
public class Question671 {
    public static void main(String[] args) {
        Question671 question671 = new Question671();
        TreeNode root = new TreeNode(2 , new TreeNode(2, new TreeNode(2), new TreeNode(3, new TreeNode(5), new TreeNode(3))),
                new TreeNode(2, new TreeNode(2), new TreeNode(4)));
        int secondMinimumValue = question671.findSecondMinimumValue(root);
        System.out.println(secondMinimumValue);
    }


    /**
     * 解法一：先序遍历提取val值，在去重排序即可    性能低下
     * @param root
     * @return
     */
    public int findSecondMinimumValue1(TreeNode root) {
        preOrder(root);
        List<Integer> res = values.parallelStream().distinct().sorted().collect(Collectors.toList());
        if (res.size() == 1) {
            return -1;
        } else {
            return res.get(1);
        }
    }

    List<Integer> values = new ArrayList<>();
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }


    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        return ans;
    }
    int ans = -1;
    // 解法二：同时遍历，但是用上题目的二叉树特殊特性
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        // 如果当前节点的左右子树值不相等，则记录其中的小的那个值
        if (root.left.val != root.right.val) {
            int max = Math.max(root.left.val, root.right.val);
            // 第一次 根节点值赋给ans，后面比这个小的就是第二小的值了
            ans = ans == -1 ? max : ans > max ? max : ans;
        }
        // 递归遍历
        traverse(root.left);
        traverse(root.right);
    }
}
