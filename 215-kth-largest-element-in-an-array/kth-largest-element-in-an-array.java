class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for(int i = 0 ;i<n ; i++){
            pq.offer(nums[i]);
        }
        for(int i  = 0;i<k-1;i++){
            pq.poll();
        }
        return pq.peek();
    }
}