package LeetCode.binarysearch;

import java.util.Arrays;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/19 23:02
 */

/**
 * 题目描述：给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 示例：
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 *
 *
 * 提示：
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间 [0, 2147483647] 内
 */
public class Interview1606 {
    public static void main(String[] args) {
        Interview1606 interview1606 = new Interview1606();
        int[] a = {-2147483648, 1};
        int[] b = {2147483647, 0};
        int ans = interview1606.smallestDifference(a, b);
        System.out.println(ans);
    }

    /**
     * 使用这种双指针遍历超时，todo 使用二分查找解决超时
     * @param a
     * @param b
     * @return
     */
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                // a[i]比b[j]的小
                int sub = a[i] - b[j];
                if (sub < 0) {
                    if ( Integer.MIN_VALUE < Math.abs(sub) && Math.abs(sub) < minValue ) {
                        minValue = Math.abs(sub);
                        break;
                    }
                }
                if (sub == 0) {
                    return 0;
                }
                if (sub > 0 && sub < minValue) {
                    minValue = sub;
                }
            }
        }
        return minValue;

    }
}
