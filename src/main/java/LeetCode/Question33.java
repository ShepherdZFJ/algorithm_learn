package LeetCode;

import java.util.*;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/18 19:35
 */
public class Question33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        int result = search(nums, target);
        System.out.println(result);

    }
    public static int search(int[] nums, int target) {
        //方法一：直接遍历
//        if (nums.length > 0) {
//            for (int i = 0; i < nums.length; i++) {
//                if (target == nums[i]) {
//                    result = i;
//                    break;
//                }
//            }
//        }
        if (nums.length > 0) {
            Map<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                index.put(nums[i], i);
            }
            Integer result = index.get(target);
            if (result == null) {
                result = -1;
            }
            return result;

        }

        return -1;
    }

//    int binarySearch(List<Integer> list, int left, int right, int target) {
//        int mid;
//        while (left <= right) {
//            mid = (left + right) / 2;
//            if (list.get(mid) == target) {
//                return
//            }
//        }
//    }
}
