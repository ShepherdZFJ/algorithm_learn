package LeetCode.listnode;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/20 15:03
 */

import LeetCode.listnode.ListNode;

/**
 * 题目描述：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class Question19 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = removeNthFromEnd(list, 5);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        ListNode result = head;
        ListNode answer = result;
        for (int i = 0; i < n - 1; i++) {
            if (node1.next != null) {
                node1 = node1.next;
            }
        }
        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        if (node2 == head) {
            return head.next;
        }


        while (head != null) {
            if (head.next == node2) {
                result.next = node2.next;
                break;
            } else {
                head = head.next;
                result.next = head;
                result = result.next;
            }
        }
        return answer;

    }
}
