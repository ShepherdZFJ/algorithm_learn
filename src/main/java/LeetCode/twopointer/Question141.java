package LeetCode.twopointer;


/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/12 16:21
 */

/**
 * 题目描述：给定一个链表，判断链表中是否有环
 */
public class Question141 {
    public static void main(String[] args) {

    }



    public boolean hasCycle1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解法：快慢指针：用两个指针，一个跑得快，一个跑得慢。如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环；
     * 如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表含有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        //初始快、慢指针都指向头节点head
        fast = slow = head;
        //fast每次走2步，slow每次走1步，如果fast的下一节点为空，就说明没有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //如果相遇，就说明有环
            if (fast == slow) return true;
        }
        return false;
    }
}
