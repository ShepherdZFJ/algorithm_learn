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
        List<List<Integer>> lists = question102.levelOrder1(root);
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
            // 判断当前结果集result是否超过当前节点的高度，超过了只需要获取当前高度的子集追加node即可，没超过，就得新增当前层高子集
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

    // 优质解法
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 循环控制从上向下⼀层层遍历
        while (!q.isEmpty()) {
            // 队列大小 这里的size其实就是同一层的数量
            int sz = q.size();
            // 记录这一层的节点值
            List<Integer> level = new LinkedList<>();
            // 控制每一层从左到右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}
