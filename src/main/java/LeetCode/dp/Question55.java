package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/16 19:10
 */
public class Question55 {
    public static void main(String[] args) {
        Question55 question55 = new Question55();
        int[] nums = {3,2,1};
        boolean b = question55.canJump(nums);
        System.out.println(b);
    }
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length <=1) {
            return true;
        }
        int[] dp = new int[length];
        dp[length-2] = nums[length-2];
        for (int i = length - 3; i >= 0; i--) {
            int n = nums[i];
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if ((i+j) == length) {
                    break;
                }
                int sum = j + dp[i+j];
                max = max > sum ? max : sum;
                dp[i] = max;
            }

        }
        return dp[0] >= length-1;
    }
}
