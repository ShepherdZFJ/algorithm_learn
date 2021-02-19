package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/22 10:56
 */
public class Question123 {
    public static void main(String[] args) {
        int[] prices ={2};
        int max = maxProfit(prices);
        System.out.println(max);
    }

        public static int maxProfit(int[] prices) {
            if(prices==null || prices.length==0) {
                return 0;
            }
            int n = prices.length;
            //定义二维数组，5种状态
            int[][] dp = new int[n][5];
            //初始化第一天的状态
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0;
            dp[0][3] = -prices[0];
            dp[0][4] = 0;
            for(int i=1;i<n;++i) {
                //dp[i][0]相当于初始状态，它只能从初始状态转换来
                dp[i][0] = dp[i-1][0];
                //处理第一次买入、第一次卖出
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
                //处理第二次买入、第二次卖出
                dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
                dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
            }
            //返回最大值
            return Math.max(Math.max( Math.max(dp[n-1][0],dp[n-1][1]),Math.max(dp[n-1][2],dp[n-1][3]) ),dp[n-1][4]);
    }


}
