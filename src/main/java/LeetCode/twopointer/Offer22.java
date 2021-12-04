package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/12 17:20
 */

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
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
