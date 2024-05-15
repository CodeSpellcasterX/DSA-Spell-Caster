class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        int i = 0;
        while (i < nums.length) {
            ans = ans ^ (i + 1 ) ^ nums[i];
            i++;
        }
        return ans;
    }
}