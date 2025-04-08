class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i = nums.length-1;
        while(i>=0) {
            if(set.contains(nums[i])) {
                break;
            }
            set.add(nums[i]);
            i--;
        }
        int j = ((i + 1) % 3) > 0 ? 1 : 0;
        return (i + 1) / 3 + j;
    }
}