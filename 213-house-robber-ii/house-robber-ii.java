import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: Rob [0...n-2]
        int[] memo1 = new int[n];
        Arrays.fill(memo1, -1);
        int option1 = robHelper(nums, 0, n - 2, memo1);

        // Case 2: Rob [1...n-1]
        int[] memo2 = new int[n];
        Arrays.fill(memo2, -1);
        int option2 = robHelper(nums, 1, n - 1, memo2);

        return Math.max(option1, option2);
    }

    private int robHelper(int[] nums, int i, int end, int[] memo) {
        if (i > end) return 0;
        if (memo[i] != -1) return memo[i];

        int pick = nums[i] + robHelper(nums, i + 2, end, memo);
        int notPick = robHelper(nums, i + 1, end, memo);

        return memo[i] = Math.max(pick, notPick);
    }
}
