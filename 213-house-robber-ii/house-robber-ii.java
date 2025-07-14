class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int dp1[] = new int[n+1];
        int dp2[] = new int[n+1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int p1  = decide1(n-1,nums,dp1);
        int p2  = decide2(n-2,nums,dp2);
        return Math.max(p1,p2);
    }

    public static int decide2(int i , int[] nums , int[] dp2){
        if(i<0) return 0;
        if(i==0) return nums[0];
        if(dp2[i]!=-1) return dp2[i];
        int npick = decide2(i-1,nums,dp2);
        int pick  = nums[i] + decide2(i-2,nums,dp2);
        return dp2[i] = Math.max(pick, npick);
    }
    public static int decide1(int i , int[] nums , int[] dp1){
        if(i<1) return 0;
        if(i==1) return nums[1];
        if(dp1[i]!=-1) return dp1[i];
        int npick = decide1(i-1,nums,dp1);
        int pick  = nums[i] + decide1(i-2,nums,dp1);
        return dp1[i] = Math.max(pick, npick);
    }
}