package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/14 20:57
 */
public class Question11 {
    public static void main(String[] args) {
        Question11 question11 = new Question11();
        int[] height = {1,1};
        int maxArea = question11.maxArea(height);
        System.out.println(maxArea);
    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(right > left) {
            int water = Math.min(height[left], height[right]) * (right-left);
            if (water > max) {
                max = water;
            } else {
                if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return max;
    }
}
