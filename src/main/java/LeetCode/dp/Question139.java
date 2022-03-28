package LeetCode.dp;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/28 15:48
 */

/**
 * 题目描述：给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 *
 * 提示：
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class Question139 {
    public static void main(String[] args) {
        Question139 question139 = new Question139();
        String s = "applepenapple";
        String[] words = {"apple", "pen"};
        boolean b = question139.wordBreak1(s, Arrays.asList(words));
        System.out.println(b);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        DFS(s, wordDict,  new StringBuilder());
        return res;

    }
    boolean res = false;

    /**
     * 解法一，使用回溯算法，每个单词都可以重复选，且全排列组合。
     * 超时算法。。。。。。
     * @param s
     * @param wordDict
     * @param sb
     */
    void DFS(String s, List<String> wordDict, StringBuilder sb) {
        if (res) {
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (Objects.equals(s, sb.toString())) {
                res = true;
                return;
            }
            if (!s.startsWith(sb.toString())) {
                return;
            }
            if (sb.toString().length() >= s.length()) {
                return;
            }
            sb.append(wordDict.get(i));
            DFS(s, wordDict, sb);
            sb.delete(sb.length()-wordDict.get(i).length(), sb.length());
        }
    }

    /**
     * 解法二：动态规划， 以dp[i]表示前i个字符构成的字符串是否能分解成字典中出现的单词
     * 拆分可能有从0到i，动态转移方程 dp[i] = dp[j] && wordDictSet.contains(s.substring(j, i))
     * 前j个字符构成的字符串是可以拆分成字典中单词的，通从j到i的构成字符串也在字典中，说明dp[i]是可以拆分成字典中的单词的
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
