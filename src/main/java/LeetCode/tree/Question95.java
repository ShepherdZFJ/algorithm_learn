package LeetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/29 18:17
 */

/**
 * 题目描述：给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 * 1 <= n <= 8
 */
public class Question95 {
    public static void main(String[] args) {
        Question95 question95 = new Question95();
        List<TreeNode> treeNodes = question95.generateTrees(3);
        System.out.println(1);
    }


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return build(1, n);
    }

    /**
     *思路：遍历1~n当根节点所有情况
     *     对于根节点i，递归构造其所有满足条件的BST
     *     对所有满足的BST左右子树组合
     * @return
     */
    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }
        // 遍历所有1~n当根节点情况
        for (int i = lo; i <= hi; i++) {
            // 构造左子树
            List<TreeNode> leftTree = build(lo, i - 1);
            // 构造右子树
            List<TreeNode> rightTree = build(i + 1, hi);
            // 以i为根节点，上面的所有左子树、右子树组合
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }




    // 下面是普通思路，使用回溯算法遍历1~n，构造BST, 现在是对树对象修改问题没解决
    // todo
    public List<TreeNode> generateTrees1(int n) {
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
