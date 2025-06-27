class Pair{
    int row;
    int col;
    int tm;
    Pair(int row,int col, int tm){
        this.row=row;
        this.col=col;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int cnt=0;
        for(int i= 0;i<n;i++){
            for(int j = 0 ;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j]==1) cnt++;
            }
        }
        int count = 0;
        int tm = 0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            int r = node.row;
            int c = node.col;
            int t = node.tm;
            tm=Math.max(tm,t);
            for(int i = 0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>= 0 && ncol>=0&&nrow<n && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    queue.offer(new Pair(nrow,ncol,tm+1));
                    vis[nrow][ncol] = 1;
                    count++;
                }

            }
        }
        if(count!=cnt) return -1;
        return tm;
    }
}