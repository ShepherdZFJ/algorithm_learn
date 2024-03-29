package LeetCode.dp;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/2/14 20:30
 */
public class Question64 {
    public static void main(String[] args) {
        Question64 question64 = new Question64();
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}
        };
        int minPathSum = question64.minPathSum(grid);
        System.out.println(minPathSum);
    }



    public int minPathSum(int[][] grid) {
        int[][] dp = new int[200][200];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j==0) {
                    dp[i][j] = grid[i][j];
                } else {
                    if (i == 0) {
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }
                    if (j == 0) {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }
                    if (i !=0 && j != 0) {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                    }
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
