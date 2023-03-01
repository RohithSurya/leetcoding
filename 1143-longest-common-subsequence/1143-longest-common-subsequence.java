class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for(var row: dp)
            Arrays.fill(row, -1);
        return lcs(text1, text2, 0, 0, dp, m, n);
    }
    public int lcs(String s1, String s2, int i, int j, int[][] dp, int m, int n) {
        if(m==i || n==j) return 0;
        else if(dp[i][j]!=-1) return dp[i][j];
        else if(s1.charAt(i)==s2.charAt(j)) {
            dp[i][j] = 1+lcs(s1, s2, i+1, j+1, dp, m, n);
        } else {
             dp[i][j] = Math.max(lcs(s1, s2, i, j+1,dp, m, n), lcs(s1, s2, i+1, j, dp, m, n));
        }
        return dp[i][j];
    }
}