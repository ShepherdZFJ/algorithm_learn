package LeetCode.listnode;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/9 11:18
 */


/**
 * 题目描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class Question21 {
    public static void main(String[] args) {
        Question21 question21 = new Question21();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = question21.mergeTwoLists1(list1, list2);
        System.out.println(listNode);
    }


    // 解法1：双指针
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 虚拟节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }

    //解法2：递归 answer 完美解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 自己无脑写的  智障解法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = mergeTwoLists(null, list1, list2);
        return ans;
    }

    public ListNode mergeTwoLists(ListNode root, ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return root;
        }
        ListNode next = null;
        if (list1 == null) {
            if (list2.next != null) {
                next = new ListNode();
            }
            if (root == null) {
                root = new ListNode(list2.val, next);
            } else {
                root.val = list2.val;
                root.next = next;
            }
            mergeTwoLists(root.next, list1, list2.next);
        }
        if (list2 == null) {
            if (list1.next != null) {
                next = new ListNode();
            }
            if (root == null) {
                root = new ListNode(list1.val, next);
            } else {
                root.val = list1.val;
                root.next = next;
            }
            mergeTwoLists(root.next, list1.next, list2);
        }
        if (list1 != null && list2 != null) {
                next = new ListNode();
            if (list1.val < list2.val) {
                if (root == null) {
                    root = new ListNode(list1.val, next);
                } else {
                    root.val = list1.val;
                    root.next = next;
                }
                mergeTwoLists(root.next, list1.next, list2);
            } else {
                if (root == null) {
                    root = new ListNode(list2.val, next);
                } else {
                    root.val = list2.val;
                    root.next = next;
                }
                mergeTwoLists(root.next, list1, list2.next);
            }
        }
        return root;
    }

}
