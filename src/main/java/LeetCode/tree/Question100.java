package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/25 18:22
 */

/**
 * 题目描述：给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 *
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 */
public class Question100 {

    /**
     * 解题思路：比较两棵树节点的值，然后让两棵树的左子树，右子树分别递归调用方法比较值即可
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 都为空的话，显然相同
        if (p == null && q == null) return true;
        // 一个为空，一个非空，显然不同
        if (p == null || q == null) return false;
        // 两个都非空，但 val 不一样也不行
        if (p.val != q.val) return false;

        // p 和 q 该比的都比完了
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
