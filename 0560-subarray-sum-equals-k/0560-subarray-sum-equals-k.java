class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int i = 0;
        int ans = 0;
        while( i < nums.length) {
            sum = sum + nums[i];
            if(map.containsKey(sum-k)) {
                ans = ans + map.get(sum-k);
            }
            if(map.containsKey(sum)) {
                int K = map.get(sum);
                map.put(sum, K+1);
            } else {
                map.put(sum, 1);
            }
            i++;
        }

        return ans;
    }
}