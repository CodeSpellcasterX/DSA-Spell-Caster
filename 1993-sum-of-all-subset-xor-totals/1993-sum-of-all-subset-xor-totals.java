class Solution {
    public int subsetXORSum(int[] nums) {
        
        int i = 1;
        int ans = 0 ;
        for(;i<=Math.pow(2,nums.length)-1;i++){
            // int val = 1;
            int temp = i;
            int idx = nums.length-1;
            int sub = 0;
            while(temp!=0){
                int get = 1&temp;
                if(get==1){
                    sub=sub^nums[idx];
                }
                idx--;
                temp=temp>>1;
            }
            ans= ans+sub;
        }
        return ans;
    }
}