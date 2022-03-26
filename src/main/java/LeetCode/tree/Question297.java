package LeetCode.tree;

import java.util.LinkedList;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/26 11:24
 */

/**
 * 题目描述：序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 提示：
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 */
public class Question297 {
    public static void main(String[] args) {
        Question297 question297 = new Question297();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        String serialize = question297.serialize(root);
        System.out.println(serialize);
        TreeNode node = question297.deserialize(serialize);
        System.out.println(node);
    }
    String SEP = ",";
    String NULL = "#";
    // 序列化树
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    // 序列化辅助函数
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            // 如果节点为null，使用特殊符号#标记，同时添上分隔符","
            sb.append(NULL).append(SEP);
            return;
        }
        // 先序遍历
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // 反序列化
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }
    // 反序列化辅助函数
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 获取根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        // 关键所在: 剩下节点的第一个节点一定是跟节点
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

}
