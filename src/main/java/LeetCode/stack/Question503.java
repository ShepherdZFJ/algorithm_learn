package LeetCode.stack;

import java.util.Stack;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 20:49
 */

/**
 * 题目描述：给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 * 示例 1:
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
public class Question503 {

    /**
     * 解题思路：使用单调栈思想，这里需要注意的是最后一个元素的下一个元素是数组的第一个元素，即循环数组，这时候最后一个元素的
     * Next Great Number就不一定是-1了，其实我们只需要数组长度翻倍，两个原数组够早一个新数组即可。
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 2*n-1; i >=0; i--) {
            while(!stack.empty() && nums[i%n] >= stack.peek()) {
                stack.pop();
            }
            res[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }
        return res;

    }
}
