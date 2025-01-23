package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/12 16:47
 */

/**
 * 题目描述：给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class Question142 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 有环
            if (fast == slow) {
                break;
            }
        }

        // 无环
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }








    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        //初始快、慢指针都指向头节点head
        fast = slow = head;
        //fast每次走2步，slow每次走1步，如果fast的下一节点为空，就说明没有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //如果相遇，就说明有环
            if (fast == slow) {
                break;
            }
        }

        //无环情况直接返回null
        if (fast == null || fast.next == null) {
            return null;
        }
        //接下来寻找环节点，假设slow走了k步，那么fast走了2k步，两者相遇，此时fast和slow都为相遇节点node
        //假设相遇点离环节点距离为m步，那么头节点head到环节点距离为k-m步(因为slow节点走k到了相遇点)，所以在head走k-m步就到环节点了
        //巧了，fast再走k-m步也到环节点，这是因为fast走了2k，比slow多走k，说明环的距离为k，根据相遇点离环节点距离为m步，所以fast再走k-m也到了环节点
        slow = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return  slow;
    }
}
