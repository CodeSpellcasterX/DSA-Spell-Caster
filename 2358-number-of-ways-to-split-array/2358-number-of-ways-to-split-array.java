class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for(int i =0;i<nums.length;i++) {
            totalSum = totalSum + nums[i];
        }
        int totalWays = 0;
        long leftSum = 0;
        for(int i =0;i<nums.length-1;i++) {
            leftSum = leftSum + nums[i];
            if(leftSum >= (totalSum-leftSum)){
                totalWays++;
            }
        }
        return totalWays;
    }
}