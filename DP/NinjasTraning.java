package DP;
import java.util.*;
public class NinjasTraning {
    public static int helper(int[][] arr, int day, int last, int[][] dp){
        if(day==0){
            int max = 0;
            for(int i = 0; i<3; i++){
                if(i!=last){
                    max = Math.max(max,arr[0][i]);
                }
            }
            return max;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int max = 0;
        for(int i = 0; i<3; i++){
            if(i!=last){
                int points = arr[day][i] + helper(arr,day-1,i,dp);
                max = Math.max(max,points);
            }
        }
        return dp[day][last] = max;
    }
    public static int ninjaTraining(int n, int points[][]){
        int[][] dp = new int[n][4];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(points,n-1,3,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][3];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<3; j++){
                points[i][j] = sc.nextInt();
            }
        }
        System.out.println(ninjaTraining(n, points));
        sc.close();
    }
}
