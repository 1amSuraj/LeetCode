class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it: prerequisites){
            int a = it[0];
            int b = it[1];
            adj.get(a).add(b);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0 ;i<numCourses;i++){
            for(int a : adj.get(i)){
                indegree[a]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int cnt = 0; 
        while(!queue.isEmpty()){
            int node = queue.poll();
            cnt++;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.offer(it);
                }
            }
        }
        return cnt==numCourses ? true:false;
    }
}