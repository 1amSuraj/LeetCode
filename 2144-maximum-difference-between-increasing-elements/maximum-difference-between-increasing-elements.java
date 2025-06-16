class Solution {
    // public int maximumDifference(int[] nums) {
        // int max= 0;
        // for(int i =0;i<nums.length-1;i++){
        //     for(int j =i+1;j<nums.length;j++)
        //     max = Math.max(max, nums[j]-nums[i]);
        // }
        // if(max==0) return -1;
        // return max;
    // }
    public int maximumDifference(int[] nums){
        int max = -1;
        int minVal = nums[0];
        for(int i =1;i<nums.length;i++){
            if(nums[i]>minVal){
                max = Math.max(max, nums[i]-minVal);
            }
            else{
                minVal = nums[i];
            }
        }
        return max;

    }
}