package LeetCode.tree;


import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 11:09
 */
public class Question109 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        Question109 question109 = new Question109();
        TreeNode treeNode = question109.sortedListToBST(head);
        question109.layerOrder(treeNode);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = finMid(head);
        TreeNode root = new TreeNode(mid.val, null, null);
        ListNode leftListNode = leftListNode(head, mid);
        root.left = sortedListToBST(leftListNode);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    ListNode finMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 就在中间位置
        return slow;
    }
    ListNode leftListNode(ListNode head, ListNode mid) {
        if (head == null || head == mid) {
            return null;
        }
        ListNode temp = head;
        while (head != null && head.next != null) {
            if (head.next == mid) {
                head.next = null;
            } else {
                head = head.next;
            }
        }
        return temp;
    }

    public void layerOrder(TreeNode root) {
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


}
