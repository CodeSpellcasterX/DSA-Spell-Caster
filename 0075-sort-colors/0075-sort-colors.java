class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = nums.length-1;

        while(ones <= twos) {
            if(nums[ones]==0) {
                swap(nums, zeros, ones);
                ones++;
                zeros++;
            } else if (nums[ones]==1) {
                ones++;
            } else {
                swap(nums, ones, twos);
                twos--;
            }
        }
    }

    void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}