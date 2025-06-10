class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int a1[]= Arrays.copyOfRange(nums,1,n);
        int a2[]= Arrays.copyOfRange(nums,0,n-1);
        return Math.max(decide(a1),decide(a2));
    }
    public static int decide(int[] nums){
        int n=nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        for(int i =1 ; i<n; i++){
            int pick = nums[i];
            if(i>=2) pick+=dp[i-2]; 
            int npick = dp[i-1];
            dp[i]=Math.max(pick,npick);
        }   
        return dp[n-1];
    }
}