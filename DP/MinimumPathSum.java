package DP;

import java.util.*;

public class MinimumPathSum {
    // Memo approch
    /*
     * public static int helper(int[][] arr, int i, int j, int[][] dp){
     * if(i<0 || j<0) return Integer.MAX_VALUE;
     * if(i==0 && j==0) return arr[0][0];
     * if(dp[i][j]!=-1) return dp[i][j];
     * int downSum = Integer.MAX_VALUE;
     * int rightSum = Integer.MAX_VALUE;
     * 
     * if(i>0) downSum = helper(arr, i-1, j,dp) + arr[i][j];
     * if(j>0) rightSum = helper(arr, i, j-1,dp) + arr[i][j];
     * 
     * return dp[i][j] = Math.min(downSum, rightSum);
     * }
     */

    public static int pathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // Part of memo
        // for(int[] row : dp){
        // Arrays.fill(row,-1);
        // }
        // return helper(grid, m-1,n-1,dp);

        // Tabulation Approch
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int downSum = Integer.MAX_VALUE;
                int rightSum = Integer.MAX_VALUE;
                if (i > 0)
                    downSum = dp[i - 1][j] + grid[i][j];
                if (j > 0)
                    rightSum = dp[i][j - 1] + grid[i][j];
                int minSum = Math.min(downSum, rightSum);
                dp[i][j] = minSum;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // grid = [[1,3,1]
        // [1,5,1]
        // [4,2,1]]
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, {4,2,1} };
        System.out.println(pathSum(grid));

        sc.close();
    }
}
