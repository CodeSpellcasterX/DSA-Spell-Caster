class Solution {
    public int[] applyOperations(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length-1; i++) {
            if(nums[i]==0) {
                count++;
            }
            if(nums[i]==nums[i+1]) {
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }
        if(nums[nums.length-1]==0) {
            count++;
        }
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]!=0) {
                nums[j] = nums[i];
                j++;
            }
        }

        for(int i = nums.length-count;i<nums.length;i++) {
            nums[i] = 0;
        }

        return nums;

    }
}