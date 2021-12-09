package LeetCode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/12/8 18:29
 */
public class Question739 {
    public static void main(String[] args) {
        int[] temperatures = {200,34,225,28,222,128,53,50,247};
        Question739 question739 = new Question739();
        int[] res = question739.dailyTemperatures(temperatures);
        System.out.println(1);
    }


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
