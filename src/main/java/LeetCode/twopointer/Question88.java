package LeetCode.twopointer;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/19 16:20
 */

/**
 * 题目描述：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class Question88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m=3, n=3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]+" ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<m && j<n) {
            if(nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i<m) {
            result[k++] = nums1[i++];
        }
        while (j<m) {
            result[k++] = nums2[j++];
        }
        System.arraycopy(result, 0, nums1, 0, result.length);


    }
}

