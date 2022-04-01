package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/1 18:51
 */
public class Question1373 {
    public static void main(String[] args) {
        Question1373 question1373 = new Question1373();
//        TreeNode root = new TreeNode(1, new TreeNode(4, new TreeNode(2), new TreeNode(4)),
//                new TreeNode(3, new TreeNode(2), new TreeNode(5, new TreeNode(4), new TreeNode(6))));
        TreeNode root = new TreeNode(4, new TreeNode(3, new TreeNode(1), new TreeNode(2)), null);
        int ans = question1373.maxSumBST(root);
        System.out.println(ans);
    }


    int max = 0;
    // 超时解法
    public int maxSumBST(TreeNode root) {
       check(root);
       return max;
    }

    void check(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> res = isValidBST(root);
        if (res != null) {
            int sum = res.stream().mapToInt(Integer::intValue).sum();
            max = sum > max ? sum : max;
        }
        check(root.left);
        check(root.right);
    }

    public List<Integer> isValidBST(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    break;
                }
                if (list.get(i) >= list.get(i+1)) {
                    return null;
                }
            }
            return list;
        }
        return null;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
