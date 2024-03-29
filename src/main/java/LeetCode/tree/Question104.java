package LeetCode.tree;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/4 13:56
 */

/**
 * 题目描述：
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3
 */
public class Question104 {

    public static void main(String[] args) {
        Question104 question104 = new Question104();
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        int i = question104.maxDepth(root);
        System.out.println(i);
    }


    /**
     * 解题思路：解法一：层序遍历，记录遍历的层高即可
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> list = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        list.add(root);
        int res = 0;
        while (!list.isEmpty()) {
            TreeNode node = list.get(0);
            list.remove(0);
            Integer height = map.get(node);
            res = height > res ? height : res;
            if (node.left != null) {
                map.put(node.left, height + 1);
                list.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, height + 1);
                list.add(node.right);
            }
        }
        return res;
    }

    /****  使用回溯算法解  ****/
    int res = 0;
    int depth = 0;
    public int maxDepth1(TreeNode root) {
       traverse(root);
       return res;
    }

    // 先序遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先加上深度
        depth++;
        // 记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 递归回到之前节点，回溯，所以减去之前加的深度
        depth--;
    }

    /**** 使用动态规划解答   *****/
    // 返回当前节点的最大深度
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }






}
