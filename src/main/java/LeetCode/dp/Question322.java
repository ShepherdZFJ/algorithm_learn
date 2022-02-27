package LeetCode.dp;

import java.util.Arrays;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/14 15:40
 */

/**
 * 题目描述：给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */

public class Question322 {
    public static void main(String[] args) {
        Question322 question322 = new Question322();
        int[] coins = {1,2,5};
        int amount = 11;
        int i = question322.coinChange(coins, amount);
        System.out.println(i);
    }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        // dp(n) 的定义：输入一个目标金额 n，返回凑出目标金额 n 的最少硬币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        // 目标金额为0时，硬币数量为0
        dp[0] = 0;
        // i 当面目标金额
        for (int i = 1; i <= amount; i++) {
            // 变量硬币金额
            for (int j = 0; j < coins.length; j++) {
                // 如果硬币金额小于或等于目标金额，目标金额i和当前硬币金额coin[j]差额所需要的最少硬币数，再加上当前硬币，即+1；如果硬币金额
                // 大于了目标金额i，则超出边界。
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
