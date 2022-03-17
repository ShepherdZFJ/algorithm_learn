package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/16 19:10
 */

/**
 * 题目描述：给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class Question55 {
    public static void main(String[] args) {
        Question55 question55 = new Question55();
        int[] nums = {3,2,1,0,4};
        boolean b = question55.canJump2(nums);
        System.out.println(b);
    }
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length <=1) {
            return true;
        }
        // dp[i]表示能到最远距离
        int[] dp = new int[length];
        dp[length-2] = nums[length-2];
        for (int i = length - 3; i >= 0; i--) {
            int n = nums[i];
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if ((i+j) == length) {
                    break;
                }
                int sum = j + dp[i+j];
                max = max > sum ? max : sum;
                dp[i] = max;
            }

        }
        return dp[0] >= length-1;
    }

    /**
     *动态规划
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        // dp[i]表示能否到达i距离
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 当前位置j能达到，并且当前位置j加上能到达的位置如果超过了i，那dp[i]更新为ture，便是i位置也可以到达
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[nums.length - 1];
    }

    /**
     * 贪心算法，每次尽可能走最远，同时覆盖能走的子区间
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return true;
        }
        int[] a = new int[length];
        a[0]=1;
        for (int i = 0; i < length; i++) {
            if (a[i] == 0) {
                continue;
            }
            for (int j =1; j <= nums[i]; j++) {
                a[i+j]=1;
                if ((i+j) == length-1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump3(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // 能跳的最远距离，那接下来for循环的最大遍历值就是cover了
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            // 如果下一个的位置跳的更远就更新
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }





}
