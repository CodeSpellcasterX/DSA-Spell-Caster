class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positive = 0;
        int negative = 1;
        int ans[] = new int[nums.length];
        int i = 0;
        while(i<nums.length) {
            System.out.println(nums[i] + " " + positive + " " +  negative);
            if(nums[i]<0) {
                ans[negative] = nums[i];
                negative = negative + 2;
            } else { 
                ans[positive] = nums[i];
                positive = positive + 2;                
            }
            i++;
        }
        return ans;
    }
}