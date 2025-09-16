class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1;
        int suffix=1;
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(prefix==0)prefix=1;
            if(suffix==0)suffix=1;
            prefix=prefix*nums[i];
            suffix=suffix*nums[n-i-1];
            maxi=Math.max(maxi,Math.max(prefix,suffix));

            // double temp = prefix;
            // if(prefix < suffix ) temp = suffix ;
            // if(maxi < temp) maxi =(int) temp;
        }
        return maxi;
    }
}