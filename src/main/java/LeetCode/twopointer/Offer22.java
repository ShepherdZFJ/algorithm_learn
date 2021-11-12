package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/12 17:20
 */
public class Offer22 {

    /**
     * 快慢指针，让快指针先走 k 步，然后快慢指针开始同速前进。这样当快指针走到链表末尾 null 时，
     * 慢指针所在的位置就是倒数第 k 个链表节点（为了简化，假设 k 不会超过链表长度
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;
        while (k-- > 0)
            fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
