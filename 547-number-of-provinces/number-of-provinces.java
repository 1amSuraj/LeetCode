class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0;i<v ; i++){
            for(int j = 0; j<v ; j++){
                if(isConnected[i][j]==1 ){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int vis[] = new int[v];
        int c = 0;
        for(int i =0;i<v;i++){
            if(vis[i]==0){
                c++;
                dfs(i,adj,vis);
            }
        }
        return c;
    }
    public static void dfs(int node , ArrayList<ArrayList<Integer>> adj, int vis[]){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                dfs(it,adj,vis);
            }
        }
    }
}