package LeetCode.listnode;

import LeetCode.listnode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/20 14:18
 */

/**
 * 题目描述：反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Question206 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = reverseList1(list);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode result = null;
        ListNode pre = null;
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        Collections.reverse(listNodes);
        for (ListNode listNode : listNodes) {
            listNode.next = null;
            if (result == null) {
                result = pre = listNode;
            } else {
                pre.next = listNode;
                pre = pre.next;
            }
        }
        return result;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode next = null;
        ListNode pre = null;

        while (head != null) {
            // 保存要反转到头的那个节点
            next = head.next;
            // 要反转的那个节点指向已经反转的上一个节点(备注:第一次反转的时候会指向null)
            head.next = pre;
            // 上一个已经反转到头部的节点
            pre = head;
            // 一直向链表尾走
            head = next;
        }
        return pre;
    }

}
