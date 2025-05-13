package DP;

public class lcsString {
    public static String lcs(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        String[][] dp = new String[m][n];
        for(int i = 0; i<m; i++){
            dp[i][0] = "";
        }
        for(int j = 0; j<n; j++){
            dp[0][j] = "";
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }
                else{
                    String o1 = dp[i-1][j];
                    String o2 = dp[i][j-1];
                    dp[i][j] = (o1.length()>o2.length())? o1 : o2;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.println("Longest Common Subsequence: " + lcs(str1, str2));
    }
}
