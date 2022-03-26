package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/26 10:58
 */

/**
 * 题目描述：给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 *
 * 示例 2：
 * 输入：root = []
 * 输出：0
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 *
 * 提示：
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 */
public class Question222 {
    public static void main(String[] args) {
        Question222 question222 = new Question222();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        int ans = question222.countNodes1(root);
        System.out.println(ans);
    }

    /**
     * 解法一：使用二叉树最普通的各种遍历，统计节点即可
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        preOrder(root);
        return ans;
    }

    int ans = 0;
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        ans++;
        preOrder(root.left);
        preOrder(root.right);
    }


    /**
     * 完全二叉树：完全二叉树的特点：叶子结点只能出现在最下层和次下层，且最下层的叶子结点集中在树的左部。需要注意的是，满二叉树肯定是完全二叉树，
     * 而完全二叉树不一定是满二叉树
     * 完全二叉树左右子树其中之一一定是满二叉数， 满二叉树的节点数等于2^k-1（k为高度）
     */
    public int countNodes1(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左右子树高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
         // 如果左右⼦树的⾼度相同则是⼀棵满⼆叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        // 如果左右⾼度不一样，则继续遍历
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }
}


