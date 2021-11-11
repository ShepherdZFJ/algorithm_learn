package LeetCode.slidingwindow;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/11 16:36
 */

import java.util.*;

/**
 * 题目描述：给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 */
public class Question76 {
    public static void main(String[] args) {
        Question76 q = new Question76();
        String s = "abc";
        String t = "bb";
        String res = q.minWindow(s, t);
        System.out.println(res);

    }


    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        String result = "";
        Map<Character, Integer> needMap = charCount(t);
        List<Character> window = new ArrayList<>();
        while(right < s.length()) {
            window.add(s.charAt(right));
            right++;
            while (contain(window, needMap)) {
                result = minLen(window, result);
                window.remove(0);
                left++;
            }
        }
        return result;


    }

    public Map<Character, Integer> charCount(String t) {
        Map<Character ,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public Boolean contain(List<Character> window, Map<Character, Integer> needMap) {
        String str = listToString(window);
        Map<Character ,Integer> current = charCount(str);
        for (Map.Entry<Character, Integer> entry : needMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (current.get(key) == null) {
                return false;
            }
            if (current.get(key) < value) {
                return false;
            }
        }
        return true;
    }

    public String listToString(List<Character> window) {
        StringBuilder s = new StringBuilder();
        window.forEach(c -> {
            s.append(c);
        });
        return s.toString();
    }

    public String minLen(List<Character> window ,String result) {
        String str = listToString(window);
        if (Objects.equals(result, "")) {
            return str;
        }
        return str.length() <= result.length() ? str : result;
    }


}


