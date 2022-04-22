package LeetCode.stack;

import java.util.Stack;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/9 10:53
 */

/**
 * 题目描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Question20 {
    public static void main(String[] args) {
        Question20 question20 = new Question20();
        String s = "((";
        boolean b = question20.isValid(s);
        System.out.println(b);
    }
    // 遍历字符，使用栈stack存取字符，取出栈首元素和当前元素相比，满足有效字符就删除栈首元素，否则元素入栈
    // 最后判断栈是否为空
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 1) {
            return false;
        }
        for( int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i==0 || stack.size()==0) {
                stack.push(c);
            } else {
                Character ch = stack.peek();
                if ((ch == c && ch=='\'') || (ch + 1 == c && ch=='(') || (ch + 2 == c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
