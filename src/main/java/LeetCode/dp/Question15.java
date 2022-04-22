package LeetCode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/4 16:19
 */

/**
 * 题目描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Question15 {
    public static void main(String[] args) {
        Question15 question15 = new Question15();
        int[] nums = {3,0,-2,-1,1,2};
        List<List<Integer>> lists = question15.threeSum(nums);
        System.out.println(lists);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        // 长度小于3，直接返回空数组结果
        if (length < 3) {
            return res;
        }
        // 排序数组
        Arrays.sort(nums);
        for (int i = 0; i < length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            boolean flag = false;
            for (int j = i+1; j < length; j++) {
                // 如果第二个数已经被操作过，就直接跳过
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                // 如果第二个数最开始和就大于0，后面就直接返回了，因为后面的肯定都大于0了
                if (j == i+1 && sum > 0) {
                    flag = true;
                    break;
                }
                // 使用二分查找第三个数，找到直接插入结果返回
                int left = j+1;
                int right = length-1;
                while(left <= right) {
                    int mid = left + (right-left)/2;
                    int temp = sum + nums[mid];
                    if (temp == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[mid]);
                        res.add(list);
                        break;
                    } else if (temp > 0) {
                        right = mid - 1;
                    } else if (temp < 0) {
                        left = mid + 1;
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        return res;
    }
}
