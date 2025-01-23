package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/2/22 16:48
 */
public class Question86 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(4,
                new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        Question86 question86 = new Question86();
        ListNode node = question86.partition(listNode, 3);
        System.out.println(node);

    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode p2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            // 直接让 head 指针前进，则需要考虑p2尾节点的next是小于x的节点，最后需要把p2.next=null
             head = head.next;

            // 断开原链表中的每个节点的 next 指针
//            ListNode temp = head.next;
//            head.next = null;
//            head = temp;
        }
        p1.next = dummy2.next;
        p2.next = null;
        return dummy1.next;
    }
}
