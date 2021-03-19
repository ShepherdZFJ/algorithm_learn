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
        int n = 10;
        int maxValue = o.cuttingRope(n);
        System.out.println(maxValue);
    }
    int max = 0;
    public int cuttingRope(int n) {
        int[] a = new int[n-1];
        for (int i = 1; i < n; i++) {
            a[i-1] = i;
        }
        DFS(a, 0, 0, n, 1);
        return max;

    }

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
        DFS(a, index, sum+a[index], n, value*a[index]);

        DFS(a, index+1, sum, n, value);
    }

}
