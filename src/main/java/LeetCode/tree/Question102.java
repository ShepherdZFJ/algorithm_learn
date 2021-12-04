package LeetCode.tree;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/4 12:29
 */

/**
 * 题目描述：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层序遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Question102 {

    public static void main(String[] args) {
        Question102 question102 = new Question102();
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        List<List<Integer>> lists = question102.levelOrder(root);
        System.out.println(lists);
    }


    /**
     * 解题思路：二叉树的层数遍历只需要使用队列，一开始将root节点加入队列，再弹出对首元素，同时压入其不为null的左右节点，
     * 这样循环直到队列里面没有节点元素即可。这里用list模拟了队列
     * 这里由于每层的元素需要单独放在一个list里面，所以需要我们每一个节点所处的层高，
     * 节点层高 = 父节点层高 + 1，最后将同一层的节点value值放在一个数组中即可。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return result;
    }
}
