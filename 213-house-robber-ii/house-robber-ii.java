public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: exclude last house
        Integer[] dp1 = new Integer[n];
        int case1 = helper(n - 2, nums, 0, dp1);

        // Case 2: exclude first house
        Integer[] dp2 = new Integer[n];
        int case2 = helper(n - 1, nums, 1, dp2);

        return Math.max(case1, case2);
    }

    public int helper(int i, int[] nums, int start, Integer[] dp) {
        if (i < start) return 0;
        if (i == start) return nums[i];

        if (dp[i] != null) return dp[i];

        int notPick = helper(i - 1, nums, start, dp);
        int pick = helper(i - 2, nums, start, dp) + nums[i];

        return dp[i] = Math.max(notPick, pick);
    }
}