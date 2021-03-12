package LeetCode;




import java.util.LinkedList;
import java.util.List;


/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/23 16:31
 */
public class Question0402 {



    TreeNode topRoot = null;
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode temp = null;
        for (int i = 0; i < nums.length ; i++) {
            temp = insertAVL(temp, nums[i]);
            if(i == 0){
                topRoot = temp;
            }
        }
        return topRoot;

    }

    // 二叉查找树的插入
    TreeNode insert(TreeNode root, int x) {
        if (root == null) {
            root = new TreeNode(x);
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
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight;

    }



    // 左旋
    void L(TreeNode root) {
        TreeNode temp = root.right;
        root.right = temp.left;
        temp.left = root;
        topRoot = temp;
    }

    // 右旋
    void R(TreeNode root) {
        TreeNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        topRoot = temp;
    }

    TreeNode insertAVL(TreeNode root, int v) {
        if (root == null) {
            root = new TreeNode(v);
            return root;
        }
        if (v < topRoot.val) {
            root.left =  insert(root.left, v);
            if (getBalanceFactor(topRoot) == 2) {
                if (getBalanceFactor(topRoot.left) == 1 || getBalanceFactor(topRoot.left) == 2) {
                    // LL型，右旋
                    R(topRoot);
                } else if (getBalanceFactor(topRoot.left) == -1 || getBalanceFactor(topRoot.left) == -2) {
                    // LR型，先以root的左子树为整体进行进行左旋， 再对root右旋
                    L(topRoot.left);
                    R(topRoot);
                }
            }
            return root.left;
        } else { //v大于当前结点root.val
            root.right = insert(root.right, v);
            if (getBalanceFactor(topRoot) == -2) {
                if (getBalanceFactor(topRoot.right) == -1 || getBalanceFactor(topRoot.right) == -2) {
                    // RR型，左旋
                    L(topRoot);
                } else if (getBalanceFactor(topRoot.right) == 1 || getBalanceFactor(topRoot.right) == 2) {
                    // RL型，先以root的右子树为整体进行右旋，再对root左旋
                    R(topRoot.right);
                    L(topRoot);
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
        int[] nums = {0,1,2,3,4,5};


        Question0402 q = new Question0402();
        TreeNode root = q.sortedArrayToBST(nums);
        layerOrder(root);
    }



}
