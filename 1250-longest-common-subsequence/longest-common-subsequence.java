class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1= text1.length();
        int l2 = text2.length();
        int dp[][] = new int[l1][l2];
        for(int rows[]: dp) Arrays.fill(rows,-1);
        return f(text1,text2,l1-1,l2-1,dp); 
    }
    public int f(String s1,String s2, int n1,int n2,int[][] dp){
        if(n1<0 || n2<0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];
        if(s1.charAt(n1)==s2.charAt(n2)){
            return dp[n1][n2] = 1+ f(s1,s2,n1-1,n2-1,dp);
        }
        else{
            return dp[n1][n2]=Math.max(f(s1,s2,n1-1,n2,dp),f(s1,s2,n1,n2-1,dp));
        }
    }
}