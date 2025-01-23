package LeetCode;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/11/13 18:39
 */
public class Test {


    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int l = mid - 1;
                int r = mid + 1;
                while (l >= 0) {

                }
            }
        }
        

    }

}
