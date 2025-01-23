package LeetCode.base;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/11 14:21
 */

/**
 * 题目描述：给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class Question560 {
    public static void main(String[] args) {
        Question560 question560 = new Question560();
        int[] nums = {1,-1, 0};
        int i = question560.subarraySum(nums, 0);
        System.out.println(i);
    }


    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ans++;
            }
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }




    // 前缀和
    public int subarraySum1(int[] nums, int k) {
        int length = nums.length;
        int s[] = new int[length];
        // 当前位置的前缀和
        for(int i = 0; i < length; i++) {
          if (i==0) {
              s[i] = nums[i];
          } else {
              s[i] = s[i-1]+nums[i];
          }
        }
        int ans = 0;
        for ( int i = 0; i < length; i++) {
            // 当前位置的前缀和等于k
            if (s[i]== k) {
                ans++;
            }
            // 两个前缀和差值等于k
            for (int j = i+1; j < length; j++) {
                if ((s[j]-s[i]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
