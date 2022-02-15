package LeetCode.backtrack;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/15 15:12
 */

/**
 * 题目描述：有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 */
public class Interview0808 {
    public static void main(String[] args) {
        Interview0808 interview0808 = new Interview0808();
        String[] ans = interview0808.permutation("qewe");
        System.out.println(ans.length);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }

    }

    List<LinkedList<Character>> res = new ArrayList<>();
    public String[] permutation(String S) {
        char[] chars = new char[S.length()];
        for(int i = 0; i < S.length(); i++) {
            chars[i] = S.charAt(i);
        }
        LinkedList<Character> track = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        backtrack(chars, track, index);
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < res.size(); i++) {
            LinkedList<Character> list = res.get(i);
            StringBuilder s = new StringBuilder();
            for(Character c : list) {
                s.append(c);
            }
            if (!ans.contains(s.toString())) {
                ans.add(s.toString());
            }
        }
        return ans.toArray(new String[0]);
    }

    void backtrack(char[] chars, LinkedList<Character> track, LinkedList<Integer> index) {
        if (track.size() == chars.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (index.contains(i)) {
                continue;
            }
            track.add(chars[i]);
            index.add(i);
            backtrack(chars, track, index);
            track.removeLast();
            index.removeLast();

        }
    }
}
