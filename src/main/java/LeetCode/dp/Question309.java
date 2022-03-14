package LeetCode.dp;

import java.util.Arrays;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/14 15:51
 */
public class Question309 {
    public static void main(String[] args) {
        Question309 question309 = new Question309();
        int[] prices = {1,2,4};
        int max = question309.maxProfit(prices);
        System.out.println(max);
    }

    /**
     * 股票通用dp定义：dp[i][k][0 or 1]
     * 0 <= i <= n - 1, 1 <= k <= K
     * n 为天数，⼤ K 为交易数的上限，0 和1代表是否持有股票。
     * 在第i天交易k次且当前没有持有股票的最大收益为：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *               max(   选择 rest  ,             选择 sell     )
     *
     * 解释：今天我没有持有股票，有两种可能：reset代表没操作
     * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     *
     * 在第i天交易k次且当前持有股票的最大收益为：
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *               max(   选择 rest  ,           选择 buy         )
     *
     * 解释：今天我持有着股票，有两种可能：
     * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     *
     * 状态转移方程：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 边界：
     * dp[-1][k][0] = dp[i][0][0] = 0
     * dp[-1][k][1] = dp[i][0][1] = -infinity
     *
     * 这里题目k可以是无穷大，所以可以去掉。
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     * 解释：第i天没有持有股票 ： 第i-1天就没有持有股票的，或者第i-1天持有股票，但是第i天卖出了。
     *      第i天持有股票：第i-1天就持有股票的，或者第i天才买入的股票，这里i-2是因为买入的前一天是冷冻期
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if (i==0) {                   // 第一天买入或者不买入的最大收益
                dp[i][0]=0;               // 第一天没有持有股票的最大收益
                dp[i][1] = -prices[i];    // 第一天持有股票的最大收益
                continue;
            }
            if (i==1) {    //第二天持有或者不持有股票的最大收益
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);   //第二天没有持有股票的最大收益
                dp[i][1]= Math.max(dp[i-1][1], -prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[length-1][0]; //最后返回最后一天不持有股票最大收益，不持有股票肯定比持有股票收益高
    }

}
