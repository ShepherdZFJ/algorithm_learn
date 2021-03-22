package LeetCode.twopointer;

import java.util.ArrayList;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/21 10:37
 */

/**
 * 问题描述：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Question3 {
    public static void main(String[] args) {
        String str = "bbbb";
        int max = lengthOfLongestSubstring(str);
        System.out.println(max);
    }

    /**
     * 解题思路：使用双指针或者动态规划
     * 解法一：双指针：在java没有指针的概念，在这里代表游标或者索引的意思，其实就是两个嵌套for循环配套求职的问题；每次一当前字符开头
     * 开始往后截取子串，截取到j位置(不包含j位置的字符），然后去j位置的字符去判断有没有在子串中，不在继续往后截取子串比较，在的话与
     * 之前的max值对比大小，最终即可得到最长子串
     *
     * 解法二：使用动态规划算法：即用dp[i]数组表示位置i以字符ch结尾的最大子串，同时记录该子串，那个下个位置j的字符只需要判断是否在子串中，
     * 不在的话，dp[j]=dp[i]+1，同时重新截取子串，在的话，找到子串中位置j字符的位置，然后从该位置+1开始截取，截取到j位置（包含j位置），
     * 此时该子串的长度即为dp[j]
     * @param s
     * @return
     */

    //解法一：双指针
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (s.substring(i, j).contains(ch + "")) {
                    break;
                }
                else {
                    count++;
                }
            }
            if (max > count) ;
            else max = count;
        }
        return max;
    }

    //解法二：动态规划
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        String maxStr= s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            if (maxStr.contains(s.charAt(i)+"")) {
                int ind = maxStr.indexOf(s.charAt(i));
                maxStr = maxStr.substring(ind+1)+s.charAt(i);
                dp.add(maxStr.length());
            } else {
                maxStr = maxStr + s.charAt(i);
                dp.add(maxStr.length());
            }
        }
        int max = 0;
        for (int i = 0; i < dp.size(); i++) {
            if (dp.get(i) > max) {
                max = dp.get(i);
            }
        }
        return max;


    }
}
