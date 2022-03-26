package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/26 10:58
 */

/**
 * 完全二叉树：完全二叉树的特点：叶子结点只能出现在最下层和次下层，且最下层的叶子结点集中在树的左部。需要注意的是，满二叉树肯定是完全二叉树，
 * 而完全二叉树不一定是满二叉树
 * 完全二叉树左右子树其中之一一定是满二叉数， 满二叉树的节点数等于2^k-1（k为高度）
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


