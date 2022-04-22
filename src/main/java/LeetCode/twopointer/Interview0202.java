package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/15 11:32
 */

/**
 * 题目描述：实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
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
