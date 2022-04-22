package LeetCode.tree;

import com.sun.tools.hat.internal.model.Root;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/26 13:10
 */

/**
 * 题目描述：给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示
 */
public class Question543 {
    public static void main(String[] args) {
        Question543 question543 = new Question543();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        int ans = question543.diameterOfBinaryTree(root);
        System.out.println(ans);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        DFS(root);
        return res-1;
    }
    int res = 0;
    Map<TreeNode, Integer> memo = new HashMap<>();
    int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 选当前节点
        int select =  1+getHeight(root.left) + getHeight(root.right);
        // 不选当前节点
        int notSelect = Math.max(DFS(root.left), DFS(root.right));
        int max = select > notSelect ? select : notSelect;
        if (max > res) {
            res = max;
        }
        return max;
    }

    int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = memo.get(node.left) == null ? getHeight(node.left) : memo.get(node.left);
        int rightHeight = memo.get(node.right) == null ? getHeight(node.right) : memo.get(node.right);
        int max = leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight;
        memo.put(node, max);
        return max;
    }


    // 优美解答
    int ans;
    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        // 重点， 这里从root开始递归遍历，会遍历所有节点的深度，这样就可以统计以每个节点为根的左右深度L+R+1
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

}
