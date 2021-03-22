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
