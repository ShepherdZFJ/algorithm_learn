package LeetCode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 14:21
 */
public class Question111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        Question111 question111 = new Question111();
        int minDepth = question111.minDepth(root);
        System.out.println(minDepth);
    }
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
}
