class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int vis[] = new int[n];
        Arrays.fill(vis,-1);
        boolean ans = true;
        for(int i =0;i<n;i++){
            if(vis[i]==-1)if(!dfs(graph,vis,0,i)) return false;
        }
        return true;

    }
    public boolean dfs(int[][] graph, int[] vis,int color,int i){
        vis[i] = color;
      
        for(int num: graph[i]){
            if(vis[num]==color) return false;
            if(vis[num]==-1 ){
                if(!dfs(graph,vis,1-color,num)){
                    return false;
                }
            }
        }
        return true;
    }
}