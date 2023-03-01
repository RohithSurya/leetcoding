class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(var row: dp)
            Arrays.fill(row, -1);
        return lcs(text1, text2, 0, 0, dp);
    }
    public int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if(s1.length()==i || s2.length()==j) return 0;
        else if(dp[i][j]!=-1) return dp[i][j];
        else if(s1.charAt(i)==s2.charAt(j)) {
            dp[i][j] = 1+lcs(s1, s2, i+1, j+1, dp);
        } else {
             dp[i][j] = Math.max(lcs(s1, s2, i, j+1,dp), lcs(s1, s2, i+1, j, dp));
        }
        return dp[i][j];
    }
}