package LeetCode.tree;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/4 13:23
 */

/**
 * 题目描述：给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回锯齿形层序遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Question103 {

    public static void main(String[] args) {
        Question103 question103 = new Question103();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null),
                new TreeNode(3, null, new TreeNode(5, null, null)));
        List<List<Integer>> lists = question103.zigzagLevelOrder(root);
        System.out.println(lists);
    }


    /**
     * 解题思路：二叉树的层数遍历只需要使用队列，一开始将root节点加入队列，再弹出对首元素，同时压入其不为null的左右节点，
     * 这样循环直到队列里面没有节点元素即可。这里用list模拟了队列
     * 这里由于每层的元素需要单独放在一个list里面，所以需要我们每一个节点所处的层高，
     * 节点层高 = 父节点层高 + 1，最后将同一层的节点value值放在一个数组中即可。
     * 这里的结果需要对每层的节点进行交替反转遍历，所以只需要先按照正常层序遍历，然后对每一层的values值进行一个交替反转操作即可。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for (int i = 0 ; i < result.size(); i++) {
            if (i % 2 == 0) {
                continue;
            }
            List<Integer> temp = result.get(i);
            Collections.reverse(temp);
            result.set(i, temp);
        }
        return result;

    }
}
