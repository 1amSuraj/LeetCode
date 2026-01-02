// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int n = nums.length;
//         int c = 0 ;
//         int left = 0 ;
//         int max= 0;
//         Queue<Integer> queue = new LinkedList<>();
//         for(int right = 0; right<n;right++){
//             if(nums[right]==0){
//                 queue.offer(right);
//                 if(c==k){
//                     left = Math.max(left,queue.poll()+1);
//                 }
//                 else{
//                     c++;
//                 }
//             }
//             max = Math.max(max, right-left+1);
//         }
//         return max;
//     }
// }
class Solution{
    public int longestOnes(int[] nums, int k){
        int c = 0;
        int max = 0;
        int left = 0;
        Queue<Integer> queue = new LinkedList<>();
        if(k==0){
            for(int i = 0;i<nums.length;i++){
                if(nums[i]==1) c++;
                if(nums[i]==0) c =0;
                max= Math.max(max,c);
            }
            return max;
        }
        for(int right = 0;right<nums.length; right++){
            if(nums[right]==0  && c==k){
                while(queue.poll()!=0){
                    // left++;
                }
                c--;
            }
            if(nums[right]==1) queue.offer(1);
            if(nums[right]==0) {
                queue.offer(0);
                c++;
            }
            max = Math.max(max, queue.size());
        }
        return max;
    }
}