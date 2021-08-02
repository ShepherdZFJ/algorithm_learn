package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/8/2 15:33
 */
public class Question53 {
    public static void main(String[] args) {
        int nums[]={-2000};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                dp.add(nums[i]);
            } else {
                dp.add(Math.max(dp.get(i-1)+nums[i], nums[i]));
            }
        }
        return dp.stream().max(Integer::compareTo).get();
    }
}
