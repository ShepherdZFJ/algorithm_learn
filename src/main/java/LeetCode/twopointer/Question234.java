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
}
