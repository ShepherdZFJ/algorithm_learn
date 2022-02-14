package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/8/2 15:33
 */

/**
 * 题目描述：给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class Question53 {
    public static void main(String[] args) {
        int nums[]={-2000};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                dp.add(nums[i]);
            } else {
                dp.add(Math.max(dp.get(i-1)+nums[i], nums[i]));
            }
        }
        return dp.stream().max(Integer::compareTo).get();
    }
}
