package LeetCode.listnode;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/2/29 17:56
 */
public class Question83 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        Question83 question83 = new Question83();
        ListNode node = question83.deleteDuplicates(head);
        System.out.println(node);
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
