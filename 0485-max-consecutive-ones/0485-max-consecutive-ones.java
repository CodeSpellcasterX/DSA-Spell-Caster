class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        
        for(int i =0;i<nums.length;){
            int ans = 0;
            if(nums[i]==1){
                while(i<nums.length&&nums[i]==1){
                    i++;
                    ans++;
                }
                count=Math.max(count,ans);
            }else{
                i++;
            }
        }
        return count;
    }
}