class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1;
        int i = 1;
        int k = 1;
        while(i<nums.length) {
            if(nums[i]!=nums[i-1]) {
                unique++;
                nums[k] = nums[i];
                k++;
            }
            i++;
        }
        return unique;
    }
}