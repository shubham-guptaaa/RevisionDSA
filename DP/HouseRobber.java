package DP;

import java.util.*;

public class HouseRobber {
    public static int helper(int[] nums, int idx) {
        if (idx >= nums.length) return 0;
        int rob = nums[idx] + helper(nums, idx + 2);
        int skip = helper(nums, idx + 1);
        return Math.max(rob, skip);

    }

    public static int rob(int[] nums) {
        // return helper(nums, 0);
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input: nums = [1,2,3,1]
        // Output: 4
        System.out.println("Enter the number of house: ");
        int n = sc.nextInt();
        System.out.println("Enter the mount of money in the houses ");
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(rob(arr));
        sc.close();
    }
}
