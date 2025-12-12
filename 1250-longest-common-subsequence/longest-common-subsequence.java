class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int dp[][] = new int[n1][n2];
        for(int rows[]:dp) Arrays.fill(rows,-1);

        return helper(text1,text2, n1-1 , n2-1,dp);
    }
    public int helper(String text1, String text2, int n1, int n2 , int[][] dp){
        if(n1<0 || n2<0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        if(text1.charAt(n1)==text2.charAt(n2)) return dp[n1][n2]= helper(text1, text2, n1-1, n2-1, dp)+1;
        else{
            return dp[n1][n2] = Math.max(helper(text1, text2, n1-1, n2,dp),helper(text1, text2, n1, n2-1, dp));
        }
    }
}