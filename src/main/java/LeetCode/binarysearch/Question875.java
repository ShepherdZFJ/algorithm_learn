package LeetCode.binarysearch;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/22 23:07
 */

/**
 * 题目描述：珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，
 * 然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 * 示例 1：
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 *
 * 示例 2：
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 *
 * 示例 3：
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 *
 * 提示：
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
public class Question875 {
    public static void main(String[] args) {
        Question875 question875 = new Question875();
        int[] plies = {3,6,7,11};
        int speed = question875.minEatingSpeed(plies, 8);
        System.out.println(speed);

    }
    int minEatingSpeed(int[] piles, int H) {
        // 套用搜索左侧边界的算法框架
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                // 找到满足的，接着找左侧的，因为需要最小的速度
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时间复杂度 O(N)
    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        // 遍历所有香蕉堆，吃完左右的时间
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    // n为某堆香蕉的根数，此方法计算以速度speed吃完这堆香蕉需要多少小时
    int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles)
            max = Math.max(n, max);
        return max;
    }
}
