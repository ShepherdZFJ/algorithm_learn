package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/15 14:17
 */

/**
 * 题目描述：无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 */
public class Interview0807 {
    public static void main(String[] args) {
        Interview0807 interview0807 = new Interview0807();
        String[] ans = interview0807.permutation("qwe");
        System.out.println(ans);
    }

    List<LinkedList<Character>> res = new ArrayList<>();
    public String[] permutation(String S) {
        char[] chars = new char[S.length()];
        for(int i = 0; i < S.length(); i++) {
            chars[i] = S.charAt(i);
        }
        LinkedList<Character> track = new LinkedList<>();
        backtrack(chars, track, S.length());
        String[] ans = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            LinkedList<Character> list = res.get(i);
            StringBuilder s = new StringBuilder();
            for(Character c : list) {
                s.append(c);
            }
            ans[i] = s.toString();
        }
        return ans;
    }

    /**
     * 解题思路：回溯算法：对给定的字符串的所有字母进行排列组合
     * @param chars
     * @param track
     * @param length
     */
    void backtrack(char[] chars, LinkedList<Character> track, int length) {
        if (track.size() == length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            // 已经包含当前字母，则跳过
            if (track.contains(chars[i])) {
               continue;
            }
            // 选取位置i的字母
            track.add(chars[i]);
            // 递归组合其他字母，如果和当前字母相同，贼会被判断条件跳过
            backtrack(chars, track, length);
            // 移除前面选取位置i的字母
            track.removeLast();
        }
    }

}
