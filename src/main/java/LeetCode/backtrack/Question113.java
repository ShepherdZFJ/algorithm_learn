package LeetCode.backtrack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/17 15:08
 */

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * 提示：
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Question113 {
    public static void main(String[] args) {
        Question113 question113 = new Question113();
//        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), new TreeNode(13)),
//                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        TreeNode root = new TreeNode(-3, null, new TreeNode(-2));
        List<List<Integer>> lists = question113.pathSum(root, -5);
        System.out.println(lists);
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        DFS(root, target, 0, track);
        return res;
    }
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 回溯算法，深度优先算法
     * @param root
     * @param target
     * @param sum
     * @param track
     */
    void DFS(TreeNode root, int target, int sum, LinkedList<Integer> track) {
        if (root == null) {
            return;
        }
        //选取当前节点
        track.add(root.val);
        sum = sum + root.val;
        // 总和等于目标值，并且当前节点必须是叶子节点
        if (target == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(track));
            track.removeLast();
            return;
        }
        // 递归遍历左右子树
        DFS(root.left, target, sum, track);
        DFS(root.right, target, sum, track);
        // 不选取当前节点，其实就是回溯到另一条路径上
        track.removeLast();
    }



}
