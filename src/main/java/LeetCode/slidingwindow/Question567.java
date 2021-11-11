package LeetCode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/11 20:37
 */

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * 提示：
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 */
public class Question567 {
    public static void main(String[] args) {
        Question567 o = new Question567();
        String s1 = "abc";
        String s2 = "eidbacooo";
        boolean b = o.checkInclusion(s1, s2);
        System.out.println(b);

    }

    /**
     * 解题思路：处理思想也是滑动窗口算法，这里通过滑动窗口截取子串，当子串长度等于s1长度，判断子串是否是s1排列中一种，如果是直接返回true，不是的话left++
     * 判断子串是否s1排列中一种核心思想就是：统计s1字符的map和子串字符的map长度一样，且每个字符的个数一样。
     * @param s1
     * @param s2
     * @return
     */

    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        Map<Character, Integer> needMap = charCount(s1);
        Map<Character, Integer> current = new HashMap<>();
        int length = s1.length();
        while (right < s2.length()) {
            char c = s2.charAt(right);
            current.put(c, current.getOrDefault(c ,0) + 1);
            if (right + 1 - left == length) {
                Boolean flag = check(current, needMap);
                if (flag) {
                    return flag;
                }
                if (current.get(s2.charAt(left)) <=1) {
                    current.remove(s2.charAt(left));
                } else {
                    current.put(s2.charAt(left), current.get(s2.charAt(left)) - 1);
                }
                left++;
            }
            right++;

        }
        return false;
    }

    public Map<Character, Integer> charCount(String t) {
        Map<Character ,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public Boolean check(Map<Character, Integer> current, Map<Character, Integer>needMap) {
        if (current.size() != needMap.size()) {
            return false;
        }
        for(Map.Entry<Character, Integer> entry : needMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!Objects.equals(value, current.get(key))) {
                return false;
            }
        }
        return true;
    }
}
