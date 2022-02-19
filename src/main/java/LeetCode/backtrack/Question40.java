package LeetCode.backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/18 16:07
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
