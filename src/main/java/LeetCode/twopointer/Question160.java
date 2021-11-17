package LeetCode.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/17 15:09
 */
public class Question160 {
    /**
     * 解法一：使用哈希表 ：使用map存放出现的节点，如果某个节点出现2次，即为相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Map<ListNode, Boolean> map = new HashMap<>();
        while(headA != null) {
            map.put(headA, true);
            headA = headA.next;
        }
        while(headB != null) {
            if (map.get(headB) != null) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 解决二：双指针：链表 headA 和 headB 的长度分别是 m 和 n。假设链表 headA 的不相交部分有 a 个节点，
     * 链表headB 的不相交部分有 b 个节点，两个链表相交的部分有 c 个节点，则有 a+c=m，b+c=n
     *如果 a != b 则指针pA会遍历完链表 headA，指针pB会遍历完链表headB，两个指针不会同时到达链表的尾节点，然后指针pA 移到链表headB 的头节点，
     * 指针pB移到链表headA的头节点，然后两个指针继续移动，在指针pA移动了a+c+b次、指针pB移动了b+c+a次之后，两个指针会同时到达两个链表相交的节点，
     * 该节点也是两个指针第一次同时指向的节点，此时返回相交的节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
