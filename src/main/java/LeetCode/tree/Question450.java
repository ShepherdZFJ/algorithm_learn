package LeetCode.tree;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/30 16:40
 */

/**
 * 题目描述：给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 *
 * 示例 3:
 * 输入: root = [], key = 0
 * 输出: []
 *
 * 提示:
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 */
public class Question450 {
    public static void main(String[] args) {
        Question450 question450 = new Question450();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)),
                new TreeNode(8, new TreeNode(6), new TreeNode(9)));
        TreeNode treeNode = question450.deleteNode(root, 10);
        System.out.println(treeNode);
    }

    // 删除BST中某一个节点
    public TreeNode deleteNode(TreeNode root, int key) {
        // root为null直接返回
        if (root == null) {
            return null;
        }
        // 找到要删除的节点
        if (root.val == key) {
            // 如果是叶子节点，正好直接删除不需要多余的处理
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {
                // 如果要删除节点root的左子树不为空，那么找到这个左子树的最大值节点node来替换要删除节点
                // 此时问题转换为删除节点node，使用递归操作即可
                TreeNode node = findMax(root.left);
                root.val = node.val;
                root.left = deleteNode(root.left, node.val);
            } else {
                // 如果要删除节点root的右子树不为空，那么找到这个右子树的最小值节点node来替换要删除节点
                // 此时问题转换为删除节点node，使用递归操作即可
                TreeNode node = findMin(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
            // 还没找到要删除的节点，那么就根据值大小左右子树递归查找
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    // 获取当前树的最大节点
    TreeNode findMax(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }

    // 获取当前树最小节点
    TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
