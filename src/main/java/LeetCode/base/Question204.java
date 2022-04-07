package LeetCode.base;

import java.util.Arrays;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/7 16:50
 */

/**
 * 题目描述：给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 *
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 * 0 <= n <= 5 * 106
 */
public class Question204 {
    public static void main(String[] args) {
        Question204 question204 = new Question204();
        int i = question204.countPrimes(10);
        System.out.println(i);
    }

    // 超时解法
    public int countPrimes1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean b = isPrimes(i);
            if (b) {
                count++;
            }
        }
        return count;

    }
    boolean isPrimes(int n) {
        for (int i = 2; i*i <= n; i++) {
            if ((n%i) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 高效解法：如果一个数是质数，那个它与其他数的乘积一定不是质数，eg：2是质数，那个2*2，2*3.....都不是质数
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }


}
