class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer>ans=new HashSet<>();
        int n=nums.length;
        for(int num:nums){
            if(num<k){
                return -1;
            }
            if(num==k){
                continue;
            }
            ans.add(num);
        }    
        return ans.size();
        // HashSet<Integer> set = new HashSet<>();
        // int max = 0;
        // int min = Integer.MAX_VALUE;
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] > k) {
        //         set.add(nums[i]);
        //     }
        // }
        // return set.size() > 0 ? set.size() : -1;
    }
}