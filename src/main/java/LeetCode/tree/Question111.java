package LeetCode.tree;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 14:21
 */

/**
 * 题目描述：给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class Question111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        Question111 question111 = new Question111();
        int minDepth = question111.minDepth(root);
        System.out.println(minDepth);
    }

    /**
     * 层序遍历，记录每个node的层高，然后遍历到第一个节点没有子节点的高度即最低深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
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
            if (node.left == null && node.right == null) {
                res = height;
                break;
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
        return res;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root节点为第一层
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            // 遍历每一层节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 如果当前节点没有子节点，那么它的深度为最小深度
                if (cur.left == null && cur.right == null)
                    return depth;
                // 将节点的左子树、右子树加入队列中
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            // 每遍历完一层节点，深度+1
            depth++;
        }
        return depth;
    }

}
