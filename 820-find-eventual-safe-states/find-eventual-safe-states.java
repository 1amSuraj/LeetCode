class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            revAdj.add(new ArrayList<>());
        }
        int[] indegree = new int[graph.length];
        for(int i = 0; i<graph.length;i++){
            for(int it: graph[i]){
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safe  = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            safe.add(node);
            for(int it: revAdj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) queue.offer(it);
            }
        }
        Collections.sort(safe);
        return safe;

    }
}