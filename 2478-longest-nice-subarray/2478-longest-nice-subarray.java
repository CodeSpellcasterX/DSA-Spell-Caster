class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = nums[0];
        int max = 1;
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            while((ans & nums[j]) != 0) {
                ans = ans ^ nums[i];
                i++;
            }

            max = Math.max(j-i+1, max);

            ans = ans | nums[j];
        }
        return max;
    }
}