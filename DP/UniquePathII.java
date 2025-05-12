package DP;
import java.util.*;
class UniquePathII{
    //Memo

    // public static int helper(int[][] arr, int i, int j, int[][] dp){
    //     if(i==0&&j==0) return 1;
    //     if(i<0||j<0) return 0;
    //     if(arr[i][j]==1) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int down = helper(arr, i-1,j,dp);
    //     int right = helper(arr,i,j-1,dp);
    //     return dp[i][j] = down+right;
    // }
    public static int path(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        
        // concept of Memo

        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // return helper(arr,i-1,j-1,dp);
        
        //Concept of Tabulation
        dp[0][0] = 1;
        for(int i = 1; i<m; i++){
            dp[i][0] = (arr[i][0] == 1) ? 0 : dp[i-1][0]; 
        }
        for(int j = 1; j<n; j++){
            dp[0][j] = (arr[0][j]==1)? 0 : dp[0][j-1];
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(arr[i][j]==1){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(path(arr));

        sc.close();
    }
}