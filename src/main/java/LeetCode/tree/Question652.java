package LeetCode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/28 22:54
 */

/**
 * 题目描述：给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 *
 * 示例 2：
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 *
 * 提示：
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
 */
public class Question652 {
    // 记录所有⼦树以及出现的次数
    HashMap<String, Integer> memo = new HashMap<>();
    // 记录冲重复的⼦树根节点
    LinkedList<TreeNode> res = new LinkedList<>();
    /* 主函数 */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }
    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会加⼊结果集合⼀次
        if (freq == 1) {
            res.add(root);
        }
        // 给⼦树对应的出现次数加⼀
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
