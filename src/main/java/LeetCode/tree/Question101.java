package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/23 14:24
 */
public class Question101 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean flag = isSymmetric(treeNode);
        System.out.println(flag);
    }



    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Integer> preList = new ArrayList<>();
        List<Integer> preListMirror = new ArrayList<>();
        preOrder(root, preList);
        preOrderMirror(root, preListMirror);
        return Objects.equals(preList, preListMirror);


    }

    static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    static void preOrderMirror(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        preOrderMirror(root.right, list);
        preOrderMirror(root.left, list);
    }



}
