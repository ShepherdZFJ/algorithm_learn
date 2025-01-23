package LeetCode.array;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2024/3/15 16:31
 */
public class Question238 {

    public static void main(String[] args) {
        Question238 question238 = new Question238();
        int[] nums = {0,2,3,4};
        int[] arr = question238.productExceptSelf(nums);
        System.out.println(arr);
    }



    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int product = 1;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
             if (nums[i] == 0 && flag) {
                 flag = false;
                 continue;
             }
            product = nums[i] * product;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                ans[i] = product;
            } else {
                if (!flag) {
                    ans[i] = 0;
                } else {
                    ans[i] = product / nums[i];
                }

            }
        }
        return ans;
    }
}
