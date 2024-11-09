class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int n=0;
        int m=0;
        for(int i=1;i<nums.length;i++){
            n=nums[i]-nums[i-1];
            m=Math.max(m,n);
        }
        return m;
        // this is O(nlogn) solution.
    }
}