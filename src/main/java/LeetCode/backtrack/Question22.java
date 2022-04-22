package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/9 15:10
 */

/**
 * 题目描述：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 * 1 <= n <= 8
 */
public class Question22 {
    public static void main(String[] args) {
        Question22 question22 = new Question22();
        List<String> ans = question22.generateParenthesis(3);
        System.out.println(ans);
    }
    public List<String> generateParenthesis(int n) {
        DFS(n, new StringBuilder(), 0, 0);
        return res;
    }
    List<String> res = new ArrayList<>();

    /**
     * 回溯算法：根据n，'('和')'都可以取n次，但是要要求遍历过程中'('的次数要大于等于')'的次数才能保证有效括号
     * @param n
     * @param s
     * @param left 左括号'('取的数量
     * @param right 有括号')'取的数量
     */
    public void DFS(int n, StringBuilder s, int left, int right) {
        if (s.length() == 2*n) {
            if (!res.contains(s.toString())) {
                res.add(s.toString());
            }
            return;
        }
        if (left < n) {
            s.append("(");
            DFS(n, s, left+1, right);
            s.deleteCharAt(s.length()-1);
        }
        if (right < left) {
            s.append(")");
            DFS(n, s, left, right+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}
