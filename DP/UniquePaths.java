package DP;

import java.util.*;

public class UniquePaths {

    // public static int helper(int m, int n, int[][] dp) {
    //     if (m == 0 && n == 0)
    //         return 1;
    //     if (m < 0 || n < 0)
    //         return 0;
    //     if (dp[m][n] != -1)
    //         return dp[m][n];
    //     int down = helper(m - 1, n, dp);
    //     int right = helper(m, n - 1, dp);
    //     return dp[m][n] = down + right;
    // }

    public static int paths(int m, int n) {
        int[][] dp = new int[m][n];
        // for(int[] row : dp){
        // Arrays.fill(row,-1);
        // }
        // return helper(m-1,n-1,dp);
        // }
        
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int j = 0; j<n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(paths(m, n));
        sc.close();
    }
}
