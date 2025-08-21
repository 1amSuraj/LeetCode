class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); //frequency map
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->map.get(a)- map.get(b));
        for(int a : map.keySet()){
            minHeap.offer(a);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int ans[] = new int[k];
        for(int i = k-1;i>=0;i--){
            ans[i]=minHeap.poll();
        }
        return ans;
    }
}