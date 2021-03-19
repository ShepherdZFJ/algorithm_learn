package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/19 14:50
 */

/**
 * 问题描述：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class Question121 {
    public static void main(String[] args) {
        int[] prices ={7,1,5,3};
        int max = maxProfit(prices);
        System.out.println(max);
    }

    /**
     * 解题思路：通过求出相邻两天的股票差价放入一个values[]数组中，然后再使用动态规划算法求得数组中最大连续子序列和即可
     * 步骤1：通过令一个数组dp[i]表示以values[i]作为末尾数的连续子序列的最大和，在这里表示股票以prices[i+1]卖出的最大收益
     * 步骤2：因为dp[i]必须以value[i]结尾的连续子序列，所以只有两种情况：
     *       1）：这个最大的连续子序列只有一个元素，即values[i], 此时dp[i-1]是一个负值，也就是也就是以value[i-1]结尾的股
     *       票最大收益是负收益
     *       2）：这个最大的连续子序列是多个元素。此时dp[i-1]是正数，此时以values[i]结尾的最大收益为dp[i-1]+values[i]
     *       总结：dp[i] = max{values[i], dp[i-1]+values[i]}  边界：dp[0]=values[0]
     *       伪代码(核心逻辑）：for (int i = 1; i < values.length; i++) {
     *                             dp[i] = Math.max(values[i], dp[i-1]+values[i]);
     *                        }
     *        最后遍历dp[]数组求得最大值即可
     *        下面的题解使用list代替数组，这有在空间和时间性能上有极大提升
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < prices.length-1; i++){
            nums.add(prices[i+1] - prices[i]);
        }
        List<Integer> dp = new ArrayList<>();
        if (nums.size() > 0) {
            dp.add(nums.get(0));
        }
        for (int i = 1; i< nums.size(); i++) {
            dp.add(Math.max(nums.get(i), dp.get(i-1)+nums.get(i)));
        }
        int max = 0;
        for(int i = 0; i<dp.size();i++) {
            if(dp.get(i)>max) {
                max = dp.get(i);
            }
        }
        return max;
    }

    //方法二：使用双指针
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            if (prices[left] >= prices[right]) {
                left = right;
                right++;
            }else {
                res = Math.max(prices[right] - prices[left], res);
                right++;
            }
        }
        return res;
    }
}
