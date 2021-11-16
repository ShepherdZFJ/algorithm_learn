package LeetCode.twopointer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/15 11:54
 */

/**
 * 题目描述：给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表。
 */
public class Question148 {
    public static void main(String[] args) {
        Question148 question148 = new Question148();
        ListNode head = new ListNode(2, new ListNode(3, new ListNode(1, new ListNode(5, new ListNode(4)))));
        ListNode listNode = question148.sortList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    /**
     * 解法1：将链表的节点放到一个list中，再通过list根据val排序，最后组成结果链表。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        nodes = nodes.stream().sorted(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        }).collect(Collectors.toList());
        for (int i = 0 ; i < nodes.size(); i++) {
            if (i == nodes.size()- 1) {
                nodes.get(i).next = null;
                break;
            }
            nodes.get(i).next = nodes.get(i+1);
        }
        return nodes.get(0);
    }

    /**
     * 解法2：归并排序（递归法）
     * 题目要求时间空间复杂度分别为O(nlogn)O(nlogn)和O(1)O(1)，根据时间复杂度我们自然想到二分法，从而联想到归并排序；
     * 对数组做归并排序的空间复杂度为 O(n)O(n)，分别由新开辟数组O(n)O(n)和递归函数调用O(logn)O(logn)组成，而根据链表特性：
     * 数组额外空间：链表可以通过修改引用来更改节点顺序，无需像数组一样开辟额外空间；
     * 递归额外空间：递归调用函数将带来O(logn)O(logn)的空间复杂度，因此若希望达到O(1)O(1)空间复杂度，则不能使用递归。
     * 通过递归实现链表归并排序，有以下两个环节：
     * 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
     * 我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
     * 找到中点 slow 后，执行 slow.next = None 将链表切断。
     * 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
     * cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
     * 合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
     * 双指针法合并，建立辅助ListNode h 作为头部。
     * 设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
     * 返回辅助ListNode h 作为头部的下个节点 h.next。
     * 时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
     * 当题目输入的 head == None 时，直接返回None。
     *
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        //如果head为null,或者head只有一个节点直接返回
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        //获取链表的中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表从中点一分为二，tmp为后半段链表
        ListNode tmp = slow.next;
        //前半段链表以slow结尾，所以将slow的next设置为null
        slow.next = null;
        //递归
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        //合并两个有序链表
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }



}
