class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lessNum = 0;
        int pivotCount = 0;
        for(int num: nums) {
            if(num < pivot) {
                lessNum++;
            }
            if(num == pivot) {
                pivotCount++;
            }
        }
        int[] ans = new int[nums.length];
        int j = lessNum+pivotCount;
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < pivot){
                ans[k] = nums[i];
                k++;
            } else if(nums[i] > pivot){
                ans[j] = nums[i];
                j++;
                pivotCount--;
            } else {
                ans[lessNum] = nums[i];
                lessNum++;
            }
        }
        return ans;
    }
}