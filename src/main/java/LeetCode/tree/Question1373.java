package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/1 18:51
 */

/**
 * 题目描述：给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * 二叉搜索树的定义如下：
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *
 *
 * 示例 1：
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 *
 * 示例 2：
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 *
 * 示例 3：
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 *
 * 示例 4：
 * 输入：root = [2,1,3]
 * 输出：6
 *
 * 示例 5：
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 *
 * 提示：
 * 每棵树有 1 到 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
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

    // BST节点最大和
    int maxSum = 0;
    /* 主函数 */
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    // 遍历返回一个数组：4个值 ：res[0]表示以root为根的二叉树是否是BST，1是   0否。
    //                       res[1]表示以root为根的左子树的节点最小值
    //                       res[2]表示以root为根的右子树的节点最大值
    //                       res[3]表示以root为根的二叉树是BST时的节点和

    int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] {
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }
        // 递归左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        /*******后序遍历位置*******/
        int[] res = new int[4];
       // 判断以 root 为根的⼆叉树是不是 BST
        if (left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]) {
            // 以 root 为根的⼆叉树是 BST
            res[0] = 1;
            // 计算以 root 为根的BST的左子树节点最⼩值
            res[1] = Math.min(left[1], root.val);
            // 计算以 root 为根的BST的右子树节点最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以 root 为根的BST 所有节点之和
            res[3] = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
         // 以 root 为根的⼆叉树不是 BST，那么不需要任何操作
            res[0] = 0;
        }
        return res;
    }


    int max = 0;
    // 超时解法
    public int maxSumBST1(TreeNode root) {
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
