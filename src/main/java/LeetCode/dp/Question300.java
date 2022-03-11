package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/21 15:36
 */

/**
 * 问题描述：给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 */
public class Question300 {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7};
        int max = lengthOfLIS(nums);
        System.out.println(max);
    }

    /**
     * 解题思路：使用动态规划算法
     * 步骤1：步骤1：通过令一个数组dp[i]表示以nums[i]作为末尾数的递增子序列的最大和
     * 步骤2：由于子序列只需要满足递增，不需要连续，那么nums[i]需要前i-1个的dp[]对比，假如位置j是前i-1中一个，此时如果
     * nums[i]>nums[j]，并且dp[j]+1>dp[i]，那么dp[i]=dp[j]+1
     * 伪代码(核心逻辑)：for (int i = 0; i < nums.length; i++) {
     *             for (int j = 0; j < i; j++) {
     *                 if (nums[i] > nums[j] && dp.get(j)+1 > dp.get(i)) {
     *                     dp.set(i, dp.get(j)+1);
     *                 }
     *             }
     *         }
     * 边界：dp[0]=1, 在这里我们预先设置dp[i]=1
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dp.add(1);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp.get(j)+1 > dp.get(i)) {
                    dp.set(i, dp.get(j)+1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.size(); i++) {
            if (dp.get(i) > max) {
                max = dp.get(i);
            }
        }
        return max;

    }
}
