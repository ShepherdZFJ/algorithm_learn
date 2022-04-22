package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/3/23 23:23
 */

/**
 * 题目描述：给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Question78 {
    public static void main(String[] args) {
        Question78 question78 = new Question78();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = question78.subsets(nums);
        System.out.println(subsets);

    }
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 解题思路：回溯算法
     */
    List<List<Integer>> res = new ArrayList<>();
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 每次都插入
        res.add(new ArrayList<>(track));
        for (int i = 0 ; i < nums.length; i++) {
            // 排除重复插入元素
            if (track.contains(nums[i])) {
                continue;
            }
            // 防止插入重复子集，这里我们结果集的数据子集都是有序的，eg：1，2，3 那个1，3，2或者2，1，3就不应该插入了
            if (track.size() > 0) {
                Integer last = track.getLast();
                if (nums[i] < last) {
                    // 这里使用continue跳过此次操作，不能return，例如2，再次插入1不满足就return，就会导致子集2，3没有遍历到
                    continue;
                }
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

}
