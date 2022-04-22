package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/4 15:38
 */

/**
 * 题目描述：给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class Question5 {
    public static void main(String[] args) {
        Question5 question5 = new Question5();
        String s = "PATZJUJZTACCBCC";
        String res = question5.longestPalindrome(s);
        System.out.println(res);
    }
    int[][] dp = new int[1000][1000];

    /**
     * 题解：动态规划 以dp[i][j]表示s[i]到s[j]的子串是否是回文子串 是→1，不是→0；
     * 状态转移方程：dp[i][j] = s[i]==s[j] ? dp[i+1][j-1] : 0
     * 边界：dp[i][i] = 1, dp[i][i+1] = s[i]==s[i+1] ? 1 : 0
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int ans = 1;
        int start = 0;
        int end = 0;
        int length = s.length();
        // 初始化边界dp[i][i], dp[i][i+1]的值
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            if (i < length -1) {
                if (s.charAt(i) == s.charAt(i+1)) {
                   dp[i][i+1] = 1;
                   if (ans == 1) {
                       start = i;
                       end = i+1;
                       ans = 2;
                   }
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
                    if (L > ans) {
                        start = i;
                        end = j;
                        ans = L;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
