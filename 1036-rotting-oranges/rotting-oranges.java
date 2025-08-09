class Pair{
        int row, col , level ;
        Pair(int row, int col, int level){
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
class Solution {
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int cnt=0; // to count number of fresh orange and later compare with visited oranges
        Queue<Pair> queue= new LinkedList<>();

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n; j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                else if(grid[i][j]==1) cnt++;
            }
        }
        int count = 0 ;
        int lvl = 0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.col;
            int l = pair.level;
            lvl = Math.max(lvl,l);
            for(int i =0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>= 0 && ncol>=0&&nrow<m && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    vis[nrow][ncol] = 1;
                    queue.offer(new Pair(nrow,ncol,lvl+1));
                    count++;
                }
            }

        }
        if(count!=cnt) return -1;
        return lvl;
    }
}