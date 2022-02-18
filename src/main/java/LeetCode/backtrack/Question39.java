package LeetCode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/18 15:48
 */

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * 示例 1：
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 *
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 * 示例 4：
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 *
 * 示例 5：
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 *
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class Question39 {
    public static void main(String[] args) {
        Question39 question39 = new Question39();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> ans = question39.combinationSum(candidates, 7);
        System.out.println(ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        DFS(0, 0, candidates, target, track);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    void DFS(int index, int sum, int[] candidates, int target, LinkedList<Integer> track) {
        // 非负整数
        if (sum > target || index == candidates.length) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        track.add(candidates[index]);
        // 再次选取index位置元素
        DFS(index, sum+candidates[index], candidates, target, track);
        track.removeLast();
        // 取消选择
        DFS(index+1, sum, candidates, target, track);
    }
}
