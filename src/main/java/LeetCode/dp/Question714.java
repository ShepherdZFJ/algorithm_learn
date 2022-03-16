package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/14 18:09
 */

/**
 * 题目描述：给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1：
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 *
 * 示例 2：
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 *
 * 提示：
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 */
public class Question714 {
    public static void main(String[] args) {
        Question714 question714 = new Question714();
        int[] prices = {1,3,7,5,10,3};
        int max = question714.maxProfit(prices, 3);
        System.out.println(max);
    }

    /**
     * 解法一：动态规划：解题思路和{@link Question309}思想差不多，只是这里有一个交易费用，计算收益要减去交易费即可
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit1(int[] prices, int fee) {
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
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[length-1][0]; //最后返回最后一天不持有股票最大收益，不持有股票肯定比持有股票收益高
    }

    /**
     * 贪心算法
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 初始化购买花费费用 这里等于价格+手续费，因为你肯定要交易的嘛，手续费本来就是花费的一部分
        int buy = prices[0] + fee;
        // 初始化收益
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            // 如果第i购买花费小于buy， 那就选择第i天购买
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                // 第i天大于buy，说明有收益了，但是有可能这个选择不是最优的，
                // 有可能下一天会持续增长收益，那今天卖出就不是一个合适选择了，因此我们可以提供一个反悔操作，
                // 看成当前手上拥有一支买入价格为prices[i]的股票，将buy更新为prices[i]
                // 这样一来，如果下一天股票价格继续上升，我们会获得 prices[i+1]−prices[i] 的收益，
                // 加上这一天prices[i]−buy 的收益，恰好就等于在这一天不进行任何操作，而在下一天卖出股票的收益
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }


}
