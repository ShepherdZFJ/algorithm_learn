package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/6 10:40
 */

/**
 * 题目描述：给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 *
 *
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 */
public class Question108 {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 1, 5, 9};
        Question108 question108 = new Question108();
        TreeNode root = question108.sortedArrayToBST(nums);
        question108.layerOrder(root);
    }

    /**
     * 解题思路：二叉搜索树的中序遍历正好是一个升序的数组，按照这个性质我们取中间节点为根节点
     * 然后以中间节点一分为二，左区间为左子树，右区间为右子树，分别递归调用，最后构造出一个二叉搜索树即可
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if ( nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = sortedArrayToBST(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode sortedArrayToBST( int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int k = (left+right)/2;
        TreeNode root = new TreeNode(nums[k], null, null);
        root.left = sortedArrayToBST( nums, left, k-1);
        root.right = sortedArrayToBST( nums, k+1, right);
        return root;
    }




    public void layerOrder(TreeNode root) {
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
