class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] drow= {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int vis[][] = new int[n][m];
        for(int j = 0;j<m;j++){
            if(grid[0][j]==1 && vis[0][j]==0) dfs(0,j,vis,grid, drow, dcol);
            if(grid[n-1][j]==1 && vis[n-1][j]==0) dfs(n-1,j,vis, grid, drow, dcol);
        }
        for(int i = 0;i<n;i++){
            if(grid[i][0]==1 && vis[i][0]==0) dfs(i,0,vis,grid, drow, dcol);
            if(grid[i][m-1]==1 && vis[i][m-1]==0) dfs(i,m-1,vis, grid, drow, dcol);
        }
        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0 ; j< m ;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int r, int c , int[][] vis, int[][] grid, int[] drow,int[] dcol){
        vis[r][c]= 1;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                dfs(nrow,ncol, vis, grid, drow,dcol);
            }
        }
    }
}