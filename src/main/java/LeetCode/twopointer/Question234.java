package LeetCode.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/19 23:14
 */

/**
 * 题目描述：给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 */
public class Question234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        Question234 question234 = new Question234();
        boolean b = question234.isPalindrome2(head);
        System.out.println(b);
    }



    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while(head != null) {
            values.add(head.val);
            head = head.next;
        }
        if (values.size() == 1) {
            return true;
        }
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) != values.get(values.size()-1-i)) {
                return false;
            }
        }
        return true;
    }

    // 2.解法二：对比正反链表
    public boolean isPalindrome1(ListNode head) {
        List<Integer> v = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            v.add(p.val);
            p = p.next;
        }
        ListNode pre = reverse(head);
        int i = 0;
        while (pre != null) {
            if (pre.val != v.get(i)) {
                return false;
            }
            i++;
            pre = pre.next;
        }
        return true;
    }

    // 3.解法三：快慢指针找到链表重点，反转后半段对比
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head, fast=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode pre = reverse(slow);
        while (pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;

    }

    // 反转链表
    public ListNode reverse(ListNode head) {
        ListNode next;
        ListNode pre = null;
        while (head != null) {
            //
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
