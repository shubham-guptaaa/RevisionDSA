package DP;
import java.util.*;
class lcsArray{
    public static List<Integer> lcs(List<Integer> a, List<Integer> b){
        int m = a.size();
        int n = b.size();
        int[][] dp = new int[m+1][n+1];
        
        // base cases
        for(int i = 0; i<=m; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<=n; j++){
            dp[0][j] = 0;
        }
        
        // Fill the dp table
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(a.get(i-1)==b.get(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1; 
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        // Reconstruct the LCS
        List<Integer> result = new ArrayList<>();
        int i = m;
        int j = n;
        while(i>0 && j>0){
            if(a.get(i-1)==b.get(j-1)){
                result.add(0,a.get(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 1);
        List<Integer> b = Arrays.asList(3, 4, 1, 2, 1, 3);
        List<Integer> result = lcs(a, b);
        System.out.println("LCS: " + result);
    }
}
