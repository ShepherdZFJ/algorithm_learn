package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/14 18:09
 */
public class Question714 {
    public static void main(String[] args) {
        Question714 question714 = new Question714();
        int[] prices = {1,3,2,8,4,9};
        int max = question714.maxProfit(prices, 2);
        System.out.println(max);
    }
    public int maxProfit(int[] prices, int fee) {
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
}
