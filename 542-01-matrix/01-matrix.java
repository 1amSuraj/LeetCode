class Pair{
    int row;
    int col;
    int cnt;
    Pair(int row, int col , int cnt){
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        int dis[][] = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for( int j = 0; j<m;j++){
                if(mat[i][j]==0){
                    queue.offer(new Pair(i,j,0));
                    vis[i][j]=1;
                    dis[i][j]=0;
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.col;
            int cnt = pair.cnt;
            for(int i= 0;i<4;i++ ){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0){
                    queue.offer(new Pair(nrow,ncol,cnt+1));
                    dis[nrow][ncol]=cnt+1;
                    vis[nrow][ncol]= 1;
                }
            }
        }
        return dis;
    }
}