package LeetCode.backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/18 16:07
 */

/**
 * 题目描述：给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * 提示:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class Question40 {
    public static void main(String[] args) {
        Question40 question40 = new Question40();
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> ans = question40.combinationSum2(candidates, 8);
        System.out.println(ans);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        DFS(0, 0, candidates, target, track);
        return res;
    }

    // TODO 待解决组合重复的问题
    List<List<Integer>> res = new ArrayList<>();
    void DFS(int index, int sum, int[] candidates, int target, LinkedList<Integer> track) {
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 非负整数
        if (sum > target || index == candidates.length) {
            return;
        }
        track.add(candidates[index]);
        DFS(index+1, sum+candidates[index], candidates, target, track);
        track.removeLast();
        DFS(index+1, sum, candidates, target, track);
    }
}
