/*[20, 30, 40, 20]
Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
jump from stair 0 to 1: cost = |30 - 20| = 10
jump from stair 1 to 3: cost = |20-30|  = 10
Total Cost = 10 + 10 = 20*/
package DP;
import java.util.*;
public class FrogJump {
    // public static int helper(int n, int arr[],int[] dp){
    //     if(n==0) return 0;
    //     if(dp[n]!=-1) return dp[n];
    //     int jump1 = helper(n-1,arr,dp)+Math.abs(arr[n]-arr[n-1]);
    //     int jump2 = 0;
    //     if(n>1){
    //     jump2 = helper(n-2,arr,dp)+Math.abs(arr[n]-arr[n-2]);
    //     }
    //     return dp[n] = Math.min(jump1,jump2);

    // }
    public static int minCost(int n, int[] arr){
        int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        // return helper(n-1, arr,dp);
        dp[0] = 0;
        for(int i = 1; i<n; i++){
            int left = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            int right = 0;
            if(i>1){
                right = dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            dp[i] = Math.min(left,right);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element in frog Jump: ");
        int n = sc.nextInt();
        System.err.println("Enter the elements: ");
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println("Min Cost to jump the frog: "+minCost(n, arr));
        sc.close();
    }
}
