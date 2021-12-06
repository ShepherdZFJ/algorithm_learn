package LeetCode.tree;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/6 10:15
 */

/**
 * 题目描述：给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Question107 {

    public static void main(String[] args) {
        Question107 question107 = new Question107();
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        List<List<Integer>> lists = question107.levelOrderBottom(root);
        System.out.println(lists);
    }


    /**
     * 解题思路：按照第102题自上向下层序遍历再反转即可
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> list = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.get(0);
            list.remove(0);
            Integer height = map.get(node);
            if (result.size() <= height) {
                List<Integer> values = new ArrayList<>();
                values.add(node.val);
                result.add(values);
            } else {
                result.get(height).add(node.val);
            }
            if (node.left != null) {
                map.put(node.left, height + 1);
                list.add(node.left);
            }
            if (node.right != null) {
                map.put(node.right, height + 1);
                list.add(node.right);
            }
        }
        Collections.reverse(result);
        return result;

    }
}
