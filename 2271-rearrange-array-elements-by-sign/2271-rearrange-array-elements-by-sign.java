class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];

        int i = 0;
        int p = 0;
        int n = 1;

        while(i < nums.length) {
            if(nums[i]>=0) {
                ans[p] = nums[i];
                p = p + 2;
            } else {
                ans[n] = nums[i];
                n = n + 2;
            }
            i++;
        }
        return ans;
    }
}