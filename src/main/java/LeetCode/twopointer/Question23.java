package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/2/22 18:56
 */
public class Question23 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        ListNode[] list = new ListNode[3];
        list[0]=null;
        list[1]=null;
        list[2]=null;
        Question23 question23 = new Question23();
        ListNode node = question23.mergeKLists(list);
        question23.print(node);
    }

    public void print(ListNode node) {
        if (node == null) {
            System.out.println("null");
        }
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode mergeNode = mergeTwoLists(lists[0], lists[1]);
        for(int i = 2; i < lists.length; i++) {
            mergeNode = mergeTwoLists(mergeNode, lists[i]);
        }
        return mergeNode;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }
}
