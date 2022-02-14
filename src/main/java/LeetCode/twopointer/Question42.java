package LeetCode.twopointer;


/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/18 16:16
 */
public class Question42 {

    public static void main(String[] args) {
        Question42 question42 = new Question42();
        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
        int result = question42.trap(height);
        System.out.println(result);

    }

    /**
     * 解题思路：算出某⼀个位置左侧所有柱⼦的最⼤⾼度和右侧所有柱⼦的最⼤⾼度，取两者小的一个减去当前位置的高度，即当前位置可以接雨水的大小
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] leftMaxHeight = getLeftMaxHeight(height);
        int[] rightMaxHeight = getRightMaxHeight(height);
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if (min > 0 && min > height[i]) {
                result = result + min - height[i];
            }
        }
        return result;
    }

    public int[] getLeftMaxHeight(int[] height) {
        int length = height.length;
        int max = 0;
        int[] leftMaxHeight = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                leftMaxHeight[i] = 0;
            } else {
                leftMaxHeight[i] = max;
            }
            if (height[i] > max) {
                max = height[i];
            }
        }
        return leftMaxHeight;
    }

    public int[] getRightMaxHeight(int[] height) {
        int length = height.length;
        int max = 0;
        int[] rightMaxHeight = new int[length];
        for (int i = length-1; i >=0; i--) {
            if (i == length-1) {
                rightMaxHeight[i] = 0;
            } else {
                rightMaxHeight[i]=max;
            }
            if (height[i] > max) {
                max = height[i];
            }
        }
        return rightMaxHeight;
    }

    /**
     * 代码精简版
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        // 数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右算 l_max
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        // 从右向左算 r_max
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // 算答案
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i]) - height[i];
        return res;
    }
}
