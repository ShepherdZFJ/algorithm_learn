package LeetCode;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2021/3/12 13:53
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class Offer47 {
    int max = 0;
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 5},
                        {3, 2, 1}
        };
        Offer47 o = new Offer47();
        int maxValue = o.maxValueDp(grid);
        System.out.println(maxValue);
    }

    //解法一：动态规划
    public int maxValueDp(int[][] grid) {
        int[][] dp = new int[200][200];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i ==0 && j == 0) {
                    dp[i][j]=grid[i][j];
                }else {
                    if (i == 0) {
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }
                    if (j == 0) {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }
                    if (i != 0 && j != 0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                    }
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }







    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        DFS(0, 0, 0 , grid );
        return max;
    }
     void DFS(int x, int y, int sum, int[][] grid) {
        if (y >= grid[0].length || x >= grid.length) {
            return;
        } else {
            sum = sum + grid[x][y];
        }
        if (sum > max) {
            max = sum;
        }
        DFS(x+1, y, sum, grid);
        DFS(x, y+1, sum, grid);

    }
}
