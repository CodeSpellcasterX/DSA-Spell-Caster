class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        while ( i < nums.length ) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i , map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
            i++;
        }
        return new int[2];
    }
}