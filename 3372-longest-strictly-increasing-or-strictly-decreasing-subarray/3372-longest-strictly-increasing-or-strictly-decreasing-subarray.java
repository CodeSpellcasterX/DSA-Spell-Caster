class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int max = 0;
        int length = 1;
        boolean inc = nums[1] > nums[0] ? true : false;
        for(int i = 0 ; i < nums.length-1; i++) {
            if(nums[i+1] > nums[i] && inc) {
                length++;
            } else if(nums[i+1] > nums[i] && !inc) {
                length = 2;
                inc = true;
            } else if(nums[i+1] < nums[i] && !inc) {
                length++;
            } else if(nums[i+1] < nums[i] && inc) {
                length = 2;
                inc = false;
            } else {
                length = 1;
            }
            max = Math.max(max, length);
        }

        return max;
    }
}