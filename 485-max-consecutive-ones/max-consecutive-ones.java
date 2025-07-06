class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max =0 ;
        for(int arr:nums){
            if(arr==1) count++;
            else count=0;
            max=Math.max(max, count);
        }
        return max;
    }
}