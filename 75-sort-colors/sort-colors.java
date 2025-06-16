class Solution {
    // public void sortColors(int[] nums) {
    //     int arr[]=new int[301];
    //     int a[]=new int[nums.length];
    //     for(int num:nums)
    //     {
    //         arr[num]++;
    //     }
    //     int x=0;
    //     for(int i=0;i<3;i++)
    //     {
    //         while(arr[i]>0)
    //         {
    //             a[x]=i;
    //             x++;
    //             arr[i]--;
    //         } 
    //     }
    //     System.arraycopy(a, 0, nums, 0, a.length);
    // }
    public void sortColors(int[] nums){
        int left = 0;
        int curr = 0;
        int right = nums.length-1;
       
        while(curr<=right){
            if(nums[curr]==0){
                swap(nums,curr,left);
                left++;
                curr++;
            }
            else if(nums[curr]==2){
                swap(nums,curr,right);
                right--;
            }
            else{
                curr++;
            }
        }
    }
    public void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    }