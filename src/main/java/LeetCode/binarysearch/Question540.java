package LeetCode.binarysearch;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/19 22:47
 */

/**
 * 题目描述：给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 *
 * 示例 1:
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * 提示:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class Question540 {
    public static void main(String[] args) {
        Question540 question540 = new Question540();
        int[] nums = {1};
        int value = question540.singleNonDuplicate(nums);
        System.out.println(value);
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] != nums[i+1]) {
                    return nums[i];
                }
            } else if (i == nums.length-1) {
                if (nums[i] != nums[i-1]) {
                    return nums[i];
                }
            } else if (nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return -1;

    }

}
