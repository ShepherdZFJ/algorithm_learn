package LeetCode;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/23 16:31
 */
public class Question0402 {



    Map<TreeNode, Integer> map = new HashMap();
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        TreeNode temp = null;
        for (int i = 0; i < nums.length ; i++) {
            temp = insertAVL(temp, nums[i], root);
            if(i == 0){
                root = temp;
            }
        }
        return root;

    }

    // 二叉查找树的插入
    TreeNode insert(TreeNode root, int x) {
        if (root == null) {
            root = new TreeNode(x);
            map.put(root, 0);
            return root;
        }
        if ( x == root.val) {
            return root;
        }
        if (x > root.val) {
            root.right = insert(root.right, x);
            return root.right;
        }
        if (x < root.val) {
            root.left =  insert(root.left, x);
            return root.left;
        }
        return  null;
    }

    // (AVL)平衡二叉树是任意结点的左子树和右子树的高度之差的绝度值不差过1，其中左子树和右子树的高度之差称为该结点的平衡因子
    int getBalanceFactor(TreeNode node) {
        return getHeight(node.left) - getHeight(node.right);

    }

    int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = map.get(node) == null ? 0 : map.get(node);
        int rightHeight = map.get(node) == null ? 0 : map.get(node);
        return Math.max(leftHeight,rightHeight);
    }

    void updateHeight(TreeNode node) {
        map.put(node, Math.max(getHeight(node.left), getHeight(node.right)) + 1);
    }

    // 左旋
    void L(TreeNode root) {
        TreeNode temp = root.right;
        root.right = temp.left;
        temp.left = root;
        updateHeight(root);
        updateHeight(temp);
    }

    // 右旋
    void R(TreeNode root) {
        TreeNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        updateHeight(root);
        updateHeight(temp);
    }

    TreeNode insertAVL(TreeNode root, int v, TreeNode allRoot) {
        if (root == null) {
            root = new TreeNode(v);
            return root;
        }
        if (v < root.val) {
            root.left =  insert(root.left, v);
            updateHeight(root);
            updateHeight(allRoot);
            if (getBalanceFactor(allRoot) == 2) {
                if (getBalanceFactor(allRoot.left) == 1) {
                    // LL型，右旋
                    R(allRoot);
                } else if (getBalanceFactor(allRoot.left) == -1) {
                    // LR型，先以root的左子树为整体进行进行左旋， 再对root右旋
                    L(allRoot.left);
                    R(allRoot);
                }
            }
            return root.left;
        } else { //v大于当前结点root.val
            root.right = insert(root.right, v);
            updateHeight(root);
            updateHeight(allRoot);
            if (getBalanceFactor(allRoot) == -2) {
                if (getBalanceFactor(allRoot.right) == -1) {
                    // RR型，左旋
                    L(allRoot);
                } else if (getBalanceFactor(allRoot.right) == 1) {
                    // RL型，先以root的右子树为整体进行右旋，再对root左旋
                    R(allRoot.right);
                    L(allRoot);
                }
            }
            return root.right;
        }

    }

    static void layerOrder(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (! list.isEmpty()) {
            TreeNode node = list.get(0);
            list.remove(0);
            System.out.print(node.val + " ");
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,9,5};
        Question0402 q = new Question0402();
        TreeNode root = q.sortedArrayToBST(nums);
        layerOrder(root);
    }



}
