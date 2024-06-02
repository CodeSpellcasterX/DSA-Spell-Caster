class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        int ans = Integer.MAX_VALUE;
        while(i<=j) {
            int mid = i + (j-i)/2;

            ans = Math.min(ans, nums[mid]);

            if(nums[mid] > nums[j]) {
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return ans;
    }
}