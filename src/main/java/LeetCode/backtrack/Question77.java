package LeetCode.backtrack;

import java.util.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/15 10:39
 */

/**
 * 题目描述：给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]

 */
public class Question77 {
    public static void main(String[] args) {
        Question77 question77 = new Question77();
        int n=4, k=2;
        List<List<Integer>> list = question77.combine(n, k);
        System.out.println(list);
    }

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, n, k, 1);
        return res;
    }

    /**
     * 解题思路：回溯算法，算法框架如下：
     * def backtrack(...):
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(...)
     *         撤销选择
     * @param track
     * @param n
     * @param k
     * @param begin
     */
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(LinkedList<Integer> track, int n, int k, int begin) {
        // 触发结束条件
        if (track.size() == k ) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = begin; i <= n; i++) {
            // 排除不合法的选择，选择过的
            if (track.contains(i))
                continue;
            // 做选择
            track.add(i);
            // 进入下一层决策树，由于组合元素不重复，所以从下一个元素开始决策遍历
            backtrack(track, n, k, i+1);
            // 取消选择
            track.removeLast();
        }
    }

//    使用这个会超时
//    boolean isRepeat(LinkedList<Integer> track, List<List<Integer>> res) {
//        // 结果集为空直接插入
//        if (res == null || res.size() == 0) {
//            return true;
//        }
//        // 遍历结果集
//        for (List<Integer> list : res) {
//            boolean flag = false;
//            // 结果集中组合list不包含当前组合track中的某一个元素，就说明当前track组合和集合list不重复，直接break，如果list完全包含track
//            // 中的元素，就说明组合重复了
//            for(Integer value : track) {
//                if (!list.contains(value)) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                return false;
//            }
//        }
//        return true;
//    }
}
