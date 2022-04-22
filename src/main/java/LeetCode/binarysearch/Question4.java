package LeetCode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/18 16:43
 */

/**
 * 题目描述：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Question4 {
    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3};
        double result = findMedianSortedArrays(num1, num2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if (nums1.length > 0) {
            for(int i = 0; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        }
        if (nums2.length > 0) {
            for (int i = 0; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
        }
        Collections.sort(list);
        double result = 0.00;
        if (list.size() % 2 == 0) {
            result = (double)(list.get(list.size()/2 - 1) + list.get(list.size()/2)) / 2;
        } else {
            result = (double)list.get(list.size()/2);
        }
        return result;


    }
}
