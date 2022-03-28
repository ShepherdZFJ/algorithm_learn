package LeetCode.base;

import java.util.Arrays;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/28 15:19
 */

/**
 * 题目描述：给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Question128 {
    public static void main(String[] args) {
        Question128 question128 = new Question128();
        int[] nums = {0,3,7,2,5,20,8,4,6,0,1};
        int count = question128.longestConsecutive(nums);
        System.out.println(count);

    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] == nums[i]+1) {
                count++;
            } else {
                if (!(nums[i] == nums[i+1])) {
                    if (count > max) {
                        max = count;
                    }
                    count=1;
                }
            }
            if (i == nums.length-2) {
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }
}
