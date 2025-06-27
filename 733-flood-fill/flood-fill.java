class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color==image[sr][sc]) return image;
        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sr,sc));
        image[sr][sc] = color;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            int r = node.row;
            int c = node.col;
            for(int i = 0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && image[nrow][ncol]==originalColor){
                    queue.offer(new Pair(nrow,ncol));
            image[nrow][ncol] = color;
                }
            }
        }
        return image;
    }
}