package DP;
import java.util.*;
class EditDistance{
    public static int helper(String s, String t, int i, int j, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = helper(s,t,i-1,j-1,dp);
        }
        else{
            int insert = 1+helper(s,t,i-1,j,dp);
            int delete = 1+helper(s,t,i,j-1,dp);
            int replace = 1+helper(s, t, i-1, j-1, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete,replace));
        }
    }
    public static int operation(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(s, t, m-1, n-1, dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(operation(s, t));
        sc.close();
    }
}