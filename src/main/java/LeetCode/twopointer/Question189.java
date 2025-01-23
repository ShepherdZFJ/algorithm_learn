package LeetCode.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/3/14 17:54
 */
public class Question189 {

    public static void main(String[] args) {
        Question189 question189 = new Question189();
        int[] nums = {1,2,3,4,5,6,7};
        question189.rotate(nums, 3);
        System.out.println(nums);
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int index = i+k;
            if (index >= len) {
                index = index % len;
            }
            map.put(index, nums[i]);
        }
        for (int i = 0; i < len; i++) {
            nums[i]=map.get(i);
        }
    }
}
