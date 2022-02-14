package LeetCode.dp;

import java.util.Arrays;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/14 15:40
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
