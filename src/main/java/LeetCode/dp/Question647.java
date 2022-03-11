package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/11 14:08
 */

/**
 * 题目描述：给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 * 示例 2：
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 */
public class Question647 {
    public static void main(String[] args) {
        Question647 question647 = new Question647();
        int count = question647.countSubstrings("aaa");
        System.out.println(count);
    }
    int[][] dp = new int[1000][1000];
    int ans = 0;
    public int countSubstrings(String s) {
        int length = s.length();
        // 初始化边界dp[i][i], dp[i][i+1]的值
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            ans++;
            if (i < length -1) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = 1;
                    ans++;
                }
            }
        }
        // L 代表枚举子串的长度，前面边界已经列举了长度为1，2的了，这里从3开始
        // 按长度枚举，其子串的最长回文子串dp已经被计算过了
        for (int L = 3; L <= length; L++) {
            for (int i = 0; i + L -1 < length; i++) { // i为起始端点，即左端点
                int j = i + L - 1;  // j为子串的右端点 遍历：0-2 1-3 2-4 .....
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }
}
