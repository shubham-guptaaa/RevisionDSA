package DP;
import java.util.*;
class ClimbingStair {
    public static int helper(int n, int[] dp){
        if(n==0) return 1;
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = helper(n-1,dp)+helper(n-2,dp);
    }
    public static int climbStairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N: ");
        int n = sc.nextInt();
        System.out.println("Possible ways: "+climbStairs(n));
        sc.close();       
    }
}
