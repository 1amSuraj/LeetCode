class Solution {
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m= obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     int dp[][] = new int[m][n];
    //     for (int[] row : dp)
    //         Arrays.fill(row, -1);
    //     return f(m-1,n-1,obstacleGrid,dp);
    // }
    // public int f(int i, int j,int obstacleGrid[][], int dp[][]){
    //     if(i<0 || j<0) return 0;
    //     if (obstacleGrid[i][j] == 1) return 0;
    //     if(i==0 && j==0) return 1;
    //     if(dp[i][j]!=-1) return dp[i][j];

    //     int up = f(i-1,j,obstacleGrid,dp);
    //     int left = f(i,j-1,obstacleGrid,dp);
    //     return dp[i][j]=up+left;
    // }
    // public int uniquePathsWithObstacles(int[][] obstacleGrid){
    //     int m= obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     int dp[][] = new int[m][n];
    //     dp[0][0] = 1;
    //     if (obstacleGrid[0][0] == 1) return 0;
    //     for(int i = 0; i<m;i++){
    //         for(int j =0;j<n;j++){
    //             if(i==0 && j==0) continue;
    //             if(obstacleGrid[i][j]==1){
    //                 dp[i][j]=0;
    //                 continue;
    //             } 
    //             int down=0,right=0;
    //             if(i>0) down=dp[i-1][j];
    //             if(j>0) right=dp[i][j-1];
    //             dp[i][j]=down+right;
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp= new int[n+1][m+1];
        for(int[] row: dp) Arrays.fill(row,-1);
        return helper(n-1,m-1, obstacleGrid,dp);
    }
    public int helper(int i , int j , int[][] obstacleGrid, int[][] dp){
        if(i == 0 && j == 0) return obstacleGrid[0][0] == 1 ? 0 : 1; // for the condition when the obstacle is on the 0 0 place
        if(i<0 || j<0) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left = helper(i,j-1,obstacleGrid,dp);
        int up = helper(i-1, j , obstacleGrid,dp);
        return dp[i][j]=left+up;

    }
}