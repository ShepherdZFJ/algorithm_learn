package LeetCode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 18:29
 */

/**
 * 题目描述：请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，
 * 请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class Question739 {
    public static void main(String[] args) {
        int[] temperatures = {200,34,225,28,222,128,53,50,247};
        Question739 question739 = new Question739();
        int[] res = question739.dailyTemperatures(temperatures);
        System.out.println(1);
    }


    /**
     * 解题思路：单调栈算法思想，这个问题本质上也是找 Next Greater Number，只不过现在不是问你 Next Greater Number 是多少，
     * 而是问你当前距离 Next Greater Number 的距离而已。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length - 1 ; i >= 0; i--) {
           while (!stack.empty() && temperatures[i] >= temperatures[stack.peek()]) {
               stack.pop();
           }
            // 得到索引间距
            res[i] = stack.empty() ? 0 : (stack.peek() - i);
            // 将索引入栈，而不是元素
            stack.push(i);
        }
        return res;
    }
}
