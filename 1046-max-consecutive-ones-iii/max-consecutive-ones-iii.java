class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int c = 0 ;
        int left = 0 ;
        int max= 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int right = 0; right<n;right++){
            if(nums[right]==0){
                queue.offer(right);
                if(c==k){
                    left = Math.max(left,queue.poll()+1);
                }
                else{
                    c++;
                }
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}