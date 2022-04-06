package LeetCode.tree.n_tree;

import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/6 18:33
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
