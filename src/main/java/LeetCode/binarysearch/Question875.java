package LeetCode.binarysearch;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/22 23:07
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
