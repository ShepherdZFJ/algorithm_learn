package LeetCode.binarysearch;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/19 22:34
 */

/**
 * 题目描述：魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 *
 * 示例2:
 *  输入：nums = [1, 1, 1]
 *  输出：1
 */
public class Interview0803 {
    public static void main(String[] args) {
        Interview0803 interview0803 = new Interview0803();
        int[] nums = {1,2,2,2, 4, 4};
        int magicIndex = interview0803.findMagicIndex(nums);
        System.out.println(magicIndex);
    }
    public int findMagicIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
