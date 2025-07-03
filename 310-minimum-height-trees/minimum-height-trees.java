class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ;i< n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v= edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[]= new int[n+1];
        int farNode[] = new int[1];
        int maxDepth[] = new int[1];
        dfs(0,-1,vis,adj,0,farNode,maxDepth);
        // System.out.println(farNode[0]+" "+maxDepth[0]);


        int parent[] = new int[n+1];
        vis= new int[n+1];
        // Arrays.fill(parent,-1);
        maxDepth[0] = -1;
        dfs2(farNode[0],-1,vis,adj,0,farNode,maxDepth,parent);


        List<Integer> path = new ArrayList<>();
        int u = farNode[0];
        while(u!=-1){
            path.add(u);
            u = parent[u];
        }
        int size = path.size();

        if(size%2!=0) {
            return List.of(path.get(size / 2));
        }
        return List.of(path.get(size/2-1),path.get(size/2));

    }
    public void dfs(int node,int parent,int[] vis, ArrayList<ArrayList<Integer>> adj,int depth,int[] farNode , int[] maxDepth){
        vis[node] = 1;
        if(depth>maxDepth[0]){
            maxDepth[0] = depth;
            farNode[0] = node;
        }
        for(int it : adj.get(node)){
            if(vis[it]==0){
                dfs(it,node,vis,adj,depth+1,farNode,maxDepth);
            }
        }
    }
    public void dfs2(int node,int parent,int[] vis, ArrayList<ArrayList<Integer>> adj,int depth,int[] farNode , int[] maxDepth,int[] parentarr){
        vis[node] = 1;
        parentarr[node] = parent;
        if(depth>maxDepth[0]){
            maxDepth[0] = depth;
            farNode[0] = node;
        }
        for(int it : adj.get(node)){
            if(vis[it]==0){
                dfs2(it,node,vis,adj,depth+1,farNode,maxDepth,parentarr);
            }
        }
    }
}