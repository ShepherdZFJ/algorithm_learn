package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/3/15 22:35
 */


/**
 * 题目描述：给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 提示：
 * 2 <= n <= 58
 */
public class Offer14 {
    public static void main(String[] args) {
        Offer14 o = new Offer14();
        int n = 8;
        int maxValue = o.cuttingRopeDP(n);
        System.out.println(maxValue);
    }
    int max = 0;
    public int cuttingRope(int n) {
        int[] a = new int[n-1];
        // 构建可减绳子的长度
        for (int i = 1; i < n; i++) {
            a[i-1] = i;
        }
        DFS(a, 0, 0, n, 1);
        return max;

    }

    /**
     * 深度优先算法
     * @param a
     * @param index
     * @param sum
     * @param n
     * @param value
     */
    void DFS(int[] a, int index, int sum, int n, int value) {
        if (index >= a.length || sum > n) {
            return;
        }
        if (sum == n) {
            if (value > max) {
                max = value;
            }
            return ;
        }
        // 重复选当前长度的绳子
        DFS(a, index, sum+a[index], n, value*a[index]);

        // 不重复选当前长度的绳子
        DFS(a, index+1, sum, n, value);
    }

    public int cuttingRopeDP(int n) {
        //定义dp数组，dp[i]表示长度为i的绳子剪成m端后长度的最大乘积(m>1)
        int dp[] = new int[n+1];
        //初始化
        dp[2] = 1;
        //目标：求出dp[n]
        //dp[2]已知，从dp[3]开始求，直到求出dp[n]
        for(int i = 3;i <= n;i++){
            //首先对绳子剪长度为j的一段,其中取值范围为 2 <= j < i
            for(int j = 2;j < i;j++){

                //转移方程如下
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
                //Math.max(j*(i-j),j*dp[i-j]是由于减去第一段长度为j的绳子后，可以继续剪也可以不剪
                //Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]))是当j不同时，求出最大的dp[i]
            }
        }
        //现在已经求出每个长度i对应的最大乘积，返回dp[n]
        return dp[n];
    }








}
