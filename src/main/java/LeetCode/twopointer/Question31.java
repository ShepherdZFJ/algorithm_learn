package LeetCode.twopointer;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/16 17:36
 */
public class Question31 {
    /**
     *  [4,5,2,6,3,1]   →   [4,5,3,6,2,1]
     * 解题思路：首先从后向前查找第一个顺序对(i,i+1)，满足 a[i]<a[i+1]。这样「较小数」即为 a[i]a[i]
     * 。此时 [i+1,n) 必然是下降序列。
     *
     * 如果找到了顺序对，那么在区间[i+1,n) 中从后向前查找第一个元素 j 满足 a[i]<a[j]。
     * 这样「较大数」即为 a[j]。
     *
     * 交换 a[i] 与 a[j]，此时可以证明区间[i+1,n) 必为降序。我们可以直接使用双指针反转区间[i+1,n) 使其变为升序，而无需对该区间进行排序
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

