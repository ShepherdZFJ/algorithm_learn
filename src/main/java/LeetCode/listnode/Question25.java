package LeetCode.listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/2/27 14:36
 */
public class Question25 {

    public static void main(String[] args) {
        ListNode head= new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Question25 question25 = new Question25();
        ListNode node = question25.reverseKGroup(head, 1);
        System.out.println(node);
    }



    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        ListNode p = head;
        List<ListNode> list = new ArrayList<>();
        List<ListNode> ans = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p=p.next;
        }
        int size = list.size();
        int n = size/k;
        int m = size%k;
        for (int i = 0; i < n; i++) {
            List<ListNode> nodes = list.subList(i * k, i * k + k);
            for (int j = nodes.size() - 1; j >= 0; j--) {
                ans.add(nodes.get(j));
            }
        }
        if (m != 0) {
            ans.addAll(list.subList(size-m, size));
        }

        for (int i = 0; i < ans.size(); i++) {
            if (i < ans.size() - 1) {
                ans.get(i).next = ans.get(i+1);
            } else {
                ans.get(i).next = null;
            }
        }
        return ans.get(0);
    }
}
