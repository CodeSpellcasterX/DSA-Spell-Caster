class Solution {
    public boolean check(int[] nums) {
        int count = nums[0] < nums[nums.length-1] ? 1 : 0;
        int i = 0;

        while(i < nums.length-1) {
            if(nums[i]>nums[i+1]) {
                count++;
            }
            if(count==2) {
                return false;
            }
            i++;
        }
        return true;
    }
}