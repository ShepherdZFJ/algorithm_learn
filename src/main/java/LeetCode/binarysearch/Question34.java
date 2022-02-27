package LeetCode.binarysearch;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/22 23:37
 */

/**
 * 题目描述：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class Question34 {
    public static void main(String[] args) {
        Question34 question34 = new Question34();
        int[] nums = {1, 2, 4, 6, 6, 6, 8, 9, 11};
        int[] ans = question34.searchRange(nums, 6);
        Arrays.stream(ans).forEach(System.out::println);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = leftBound(nums, target);
        ans[1] = rightBound(nums, target);
        return ans;
    }

    /**
     * 寻找最左侧的值
     * @param nums
     * @param target
     * @return
     */
    int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid =  left + (right-left)/2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     * 寻找最右侧的值
     * @param nums
     * @param target
     * @return
     */
    int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid =  left + (right-left)/2;
            if (nums[mid] == target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }



}
