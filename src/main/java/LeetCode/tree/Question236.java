package LeetCode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/28 17:16
 */

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。
 *
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class Question236 {
    public static void main(String[] args) {
        Question236 question236 = new Question236();
        TreeNode root =new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7) ,new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode q = new TreeNode(5);
        TreeNode p = new TreeNode(4);
        TreeNode treeNode = question236.lowestCommonAncestor(root, p, q);
        System.out.println(treeNode);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFS(root, p, q);
        return ans;
    }

    TreeNode ans = null;


    boolean DFS(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 判断左右子树是否包含p或者q节点
        boolean left = DFS(root.left, p, q);
        boolean right = DFS(root.right, p, q);
        // 如果左右子树都满足包含p或者q节点之一，那么该节点就是最近公共祖先
        // 再或者只有一个子树满足包含p或者q节点，但是root的val值等于p或者q节点的val值，那么该节点也是最近公共祖先
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
           ans = root;
        }
        // 返回当前节点及其子树是否包含p或者q节点
        return left || right || root.val == p.val || root.val == q.val;
    }

    // 超时解法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        DFS(root);
        List<TreeNode> pNodes = childToParentMap.get(p.val);
        List<TreeNode> qNodes = childToParentMap.get(q.val);
        if (pNodes == null || qNodes == null) {
            return root;
        }
        if (pNodes.size() < qNodes.size()) {
            pNodes.add(p);
        }
        if (qNodes.size() < pNodes.size()) {
            qNodes.add(q);
        }
        int size = Math.min(pNodes.size(), qNodes.size());
        for (int i = size-1; i >= 0; i--){
            if (pNodes.get(i).val == qNodes.get(i).val) {
                return pNodes.get(i);
            }
        }
        return null;
    }

    Map<Integer , List<TreeNode>> childToParentMap = new HashMap<>();
    void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>(childToParentMap.getOrDefault(root.val, new ArrayList<>()));
        list.add(root);
        if (root.left != null) {
            childToParentMap.put(root.left.val, new ArrayList<>(list));
            DFS(root.left);
        }
        if (root.right != null) {
            childToParentMap.put(root.right.val, list);
            DFS(root.right);
        }
    }



}
