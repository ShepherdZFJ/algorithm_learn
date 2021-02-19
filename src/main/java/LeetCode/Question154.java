package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/2/19 14:18
 */
public class Question154 {
    public static void main(String[] args) {
        int[] nums={2,2,2,1,1};
        int min = findMin1(nums);
        System.out.println(min);
    }
    public int findMin(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list.stream().distinct().min(Integer::compareTo).get();
    }

    public static int findMin1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            }
            else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high -= 1;
            }
        }
        return nums[low];
    }



}
