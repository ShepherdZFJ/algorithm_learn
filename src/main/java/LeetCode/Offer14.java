package LeetCode;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/3/15 22:35
 */
public class Offer14 {
    public static void main(String[] args) {
        Offer14 o = new Offer14();
        int n = 6;
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
        if (index >= a.length) {
            return;
        }
        sum = sum + a[index];
        if (sum > n) {
            return;
        }
        value = value * a[index];
        if (sum == n) {
            if (value > max) {
                max = value;
            }
            return ;
        }
        DFS(a, index, sum, n, value);
        DFS(a, index+1, sum, n, value);
    }

}
