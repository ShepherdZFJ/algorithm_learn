package LeetCode.base;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/11 11:13
 */
public class Question283 {
    public static void main(String[] args) {
        Question283 question283 = new Question283();
        int[] nums = {0,1,0,3,12};
        question283.moveZeroes(nums);
    }
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums.length-i-1; j++) {
                if (nums[j]==0 && nums[j+1] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}
