package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/3 14:28
 */
public class Offer10_1 {
    public static void main(String[] args) {
        Offer10_1 offer10 = new Offer10_1();
        System.out.println(offer10.dp);
    }
    int[] dp = new int[101];

    public int fib(int n) {
        if (n==0 || n == 1) {
            return n % 1000000007;
        } else if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] =  (fib(n-1) + fib(n-2)) % 1000000007;
            return dp[n];
        }
    }
}
