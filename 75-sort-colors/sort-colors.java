class Solution {
    public void sortColors(int[] nums) {
        int arr[]=new int[301];
        int a[]=new int[nums.length];
        for(int num:nums)
        {
            arr[num]++;
        }
        int x=0;
        for(int i=0;i<3;i++)
        {
            while(arr[i]>0)
            {
                a[x]=i;
                x++;
                arr[i]--;
            } 
        }
        System.arraycopy(a, 0, nums, 0, a.length);
    }
    }