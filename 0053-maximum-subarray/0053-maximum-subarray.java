class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int sum = 0;
        while(i<nums.length) {
            sum = sum + nums[i];
            ans = Math.max(ans,sum);
            if(sum<0) {
                sum=0;
            }
            i++;
        }
        return ans;
    }
}