package LeetCode.listnode;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/2/26 18:26
 */
public class Question138 {

    public Node copyRandomList(Node head) {
        Node v = new Node(-1);
        Node temp = null;
        while (head != null) {
            Node n = new Node(head.val);
            n.random = head.random;
            head = head.next;
            v.next = n;

        }
        return null;
    }
}
