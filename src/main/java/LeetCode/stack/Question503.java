package LeetCode.stack;

import java.util.Stack;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 20:49
 */
public class Question503 {
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
