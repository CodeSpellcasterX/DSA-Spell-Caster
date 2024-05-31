class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 1;
        int j = nums.length-2;

        if(nums.length==1 || nums[0] != nums[1]) {
            return nums[0];
        }

        if(nums[nums.length-2] != nums[nums.length-1]) {
            return nums[nums.length-1];
        }

        while(i<=j) {
            int mid = (i+j)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid] !=nums[mid+1]) {
                return nums[mid];
            } else if (nums[mid]==nums[mid+1]) {
                if(mid%2==0) {
                    i=mid+1;
                } else {
                    j=mid-1;
                }
            } else {
                if(mid%2==1) {
                    i=mid+1;
                } else {
                    j=mid-1;
                }
            }
        }

        return -1;
    }
}