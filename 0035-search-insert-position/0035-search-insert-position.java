class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int ans = 0;
        while(i<=j) {
            int mid = (i+j)/2;
            if(nums[mid]>target) {
                j=mid-1;
                ans = mid < 0 ? 0 : mid;
            } else if (nums[mid] < target) {
                i = mid+1;
                ans = mid+1;
            } else {
                return mid;
            }
        }
        return ans;
    }
}