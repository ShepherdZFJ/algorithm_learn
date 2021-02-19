package LeetCode;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/19 13:46
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * 请找出其中最小的元素。
 */
public class Question153 {
    public static void main(String[] args) {
        int[] nums={2,2,2,1,1};
        int min = findMin1(nums);
        System.out.println(min);
    }
    //方法一：直接使用java8特性搞定
    public static int findMin(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list.stream().distinct().min(Integer::compareTo).get();
    }

    //方法二：二分查找，请注意，无论怎么旋转，从最后面往前带旋转节点都是有序的
    public static int findMin1(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

}
