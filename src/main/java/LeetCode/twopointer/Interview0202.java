package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/15 11:32
 */
public class Interview0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;
        while(k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
