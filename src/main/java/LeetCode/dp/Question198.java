package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/27 23:07
 */

import java.util.Arrays;

/**
 * 题目描述：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class Question198 {
    public static void main(String[] args) {
        Question198 question198 = new Question198();
        int[] nums = {1,2,3,1};
        int max = question198.rob(nums);
        System.out.println(max);
    }

    /**
     * 题解：动态规划，以dp[i]表示以第i天结尾能偷的最多钱，有题目可知不能连续相邻两天偷，所以dp[i]只需要关注往前2天的dp[i-2]，往前3天的dp[i-3]
     * 状态转移方程为：dp[i]=nums[i] + max(dp[i-2], dp[i-3])
     * 边界：dp[0]=nums[0], dp[1]=nums[1] dp[2] = nums[0]+nums[2]
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0]+nums[2];
        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    private int[] memo;
    public int rob2(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) return memo[start];
        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        memo[start] = res;
        return res;
    }
}
