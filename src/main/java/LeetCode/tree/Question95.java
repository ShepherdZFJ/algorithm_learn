package LeetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/29 18:17
 */
public class Question95 {
    public static void main(String[] args) {
        Question95 question95 = new Question95();
        List<TreeNode> treeNodes = question95.generateTrees(3);
        System.out.println(1);
    }
    public List<TreeNode> generateTrees(int n) {
        backtrack(n, null, new LinkedList<>());
        return res;
    }

    List<TreeNode> res = new ArrayList<>();
    void backtrack(int n, TreeNode root, LinkedList<Integer> track) {
        if (track.size() == n) {
            res.add(root);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (track.contains(i)) {
                continue;
            }
            track.add(i);
            root = insert(root, i);
            backtrack(n, root, track);
            Integer num = track.removeLast();
            root = delete(root, num);
        }
    }

    TreeNode insert(TreeNode root, int x) {
        if (root == null) {
            root = new TreeNode(x);
        }
        if (x < root.val) {
            root.left = insert(root.left, x);
        }
        if (x > root.val) {
            root.right = insert(root.right, x);
        }
        return root;
    }

    TreeNode delete(TreeNode root, int x) {
        if (root.val == x) {
            return null;
        }
        if (x > root.val) {
            root.right = delete(root.right, x);
        }
        if (x < root.val) {
            root.left = delete(root.left, x);
        }
        return root;
    }

}
