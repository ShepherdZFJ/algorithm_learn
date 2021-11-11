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
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 示例 2：
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
        String s = "a";
        String t = "a";
        String res = q.minWindow(s, t);
        System.out.println(res);

    }

    /**
     * 滑动窗口算法详见：
     * 滑动窗口思想：滑动窗口算法的思路是这样：https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%8A%80%E5%B7%A7.md
     *
     * 1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，把索引闭区间 [left, right] 称为一个「窗口」。
     *
     * 2、我们先不断地增加 right 指针扩大窗口 [left, right]，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
     *
     * 3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。同时，每次增加 left，我们都要更新一轮结果。
     *
     * 4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
     * @param s
     * @param t
     * @return
     */

    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        //获取包含字符的数量map
        Map<Character, Integer> needMap = charCount(t);
        Map<Character, Integer> current = new HashMap<>();
        List<Character> window = new ArrayList<>();
        int ansL = 0, ansR=0;
        int len = Integer.MAX_VALUE;
        while(right < s.length()) {
            char c = s.charAt(right);
            //往滑动窗口添加字符  这个window不需要客观存在，这是优化点
            window.add(c);
            //记录滑动窗口的字符数量信息
            current.put(c, current.getOrDefault(c, 0) + 1);
            // 判断滑动窗口子串是否包含了要求的字符
            while (check(needMap, current)) {
                // 获取最小子串信息，记录开始位置，和结束位置
                if (right + 1 - left < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = right  + 1;
                }
                //先对滑动窗口的第一个字符统计减1，方面后面删除该字符，left++
                if (current.containsKey(window.get(0))) {
                    current.put(window.get(0), current.get(window.get(0)) - 1);
                }
                // 删除滑动窗口第一个字符，即left右移
                window.remove(0);
               left++;
            }
            right++;
        }
        return s.substring(ansL, ansR);


    }

    public Map<Character, Integer> charCount(String t) {
        Map<Character ,Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
           map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public Boolean check(Map<Character, Integer> needMap, Map<Character, Integer> current) {
        if (needMap.size() > current.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : needMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (current.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }






}


