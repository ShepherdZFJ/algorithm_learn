package LeetCode.dp;

import java.util.Arrays;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/27 23:41
 */

/**
 * 题目描述：你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 *
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class Question213 {
    public static void main(String[] args) {
        Question213 question213 = new Question213();
        int[] nums = {1};
        int rob = question213.rob(nums);
        System.out.println(rob);
    }

    /**
     * 题解：动态规划，以dp[i]表示以第i天结尾能偷的最多钱，有题目可知不能连续相邻两天偷，所以dp[i]只需要关注往前2天的dp[i-2]，往前3天的dp[i-3]
     * 状态转移方程为：dp[i]=nums[i] + max(dp[i-2], dp[i-3])
     * 边界：dp[0]=nums[0], dp[1]=nums[1] dp[2] = nums[0]+nums[2]
     * 但是这里由于第一个房屋和最后一个房屋是相邻的，所以这里有三种情况：
     * 1.选第一个房屋，不选最后一个，即nums[0,nums.length-2]
     * 2.选最后一个，不选第一个，即nums[1, nums.length-1]
     * 3.两个都不选，nums[1, nums.length-2]
     * 或者三种情况最值，再去气质最大值即可
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
        int[] nums1 = Arrays.copyOf(nums, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length - 1);
        int[] nums3 = Arrays.copyOfRange(nums, 1, nums.length);
        int n1 = baseRob(nums1);
        int n2 = baseRob(nums2);
        int n3 = baseRob(nums3);
        int max = n1 > n2 ? n1 : n2;
        max = n3 > max ? n3 : max;
        return max;

    }
    public int baseRob(int[] nums) {
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
}
