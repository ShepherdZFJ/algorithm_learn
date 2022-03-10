package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/10 20:28
 */

/**
 * 题目描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 提示：
 * 1 <= n <= 45
 */
public class Question70 {
    public static void main(String[] args) {
        Question70 question70 = new Question70();
        int i = question70.climbStairs(7);
        System.out.println(i);
    }

    /**
     * 题解：斐波那契数列
     */
    int[] dp = new int[50];
    public int climbStairs(int n) {
        if (n == 0 || n==1) {
            return 1;
        } else if(dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = climbStairs(n-1) + climbStairs(n-2);
            return dp[n];
        }
    }

    // 深度优先解法：超时了......
    int ans = 0;
    void DFS(int n, int sum) {
        if (sum == n) {
            ans++;
            return;
        }
        if (sum > n) {
            return;
        }
        DFS(n , sum+1);
        DFS(n, sum+2);
    }
}
