class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return helper(nums, target, 0, 0, dp);
    }

    boolean helper(int[] nums, int tar, int in, int sum, Boolean[][] dp) {
        if (sum == tar) {
            return true;
        }
        if (in >= nums.length || sum > tar) {
            return false;
        }
        if (dp[in][sum] != null) {
            return dp[in][sum];
        }
        dp[in][sum] = helper(nums, tar, in + 1, sum + nums[in], dp) || helper(nums, tar, in + 1, sum, dp);
        return dp[in][sum];
    }
}