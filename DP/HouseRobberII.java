package DP;
import java.util.*;

public class HouseRobberII {
    public static int helper(int[] nums, int start, int end, int[][] dp) {
        if (end < start) return 0;
        if (end == start) return nums[start];
        if(dp[start][end]!=-1) return dp[start][end];
        int rob = nums[end] + helper(nums, start, end - 2,dp);
        int skip = helper(nums, start, end - 1,dp);
        return dp[start][end] = Math.max(rob, skip);
    }
    
    public static int rob(int[] nums) {
       int n = nums.length;
       if(n==1) return nums[0];
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++) Arrays.fill(dp[i],-1);
        // Rob houses 0 to n-2
        int first = helper(nums, 0, n - 2,dp);
        // Rob houses 1 to n-1
        int second = helper(nums, 1, n - 1,dp);
        
        return Math.max(first, second);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of house: ");
        int n = sc.nextInt();
        System.out.println("Enter the mount of money in the houses ");
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(rob(arr));
        sc.close();
    }
}
