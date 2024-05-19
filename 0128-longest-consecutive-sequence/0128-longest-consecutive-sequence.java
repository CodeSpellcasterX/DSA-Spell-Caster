class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxCount = 1;
        int count = 1;
        int previous = nums[0];
        int i = 1;

        while(i < nums.length) {
            if(nums[i]-1==previous) {
                count++;
                maxCount = Math.max(maxCount, count);
                previous++;
            } else if(nums[i]==previous) {
            } else {
                previous = nums[i];
                count = 1;
            }
            System.out.println(maxCount + " " + count + " " + previous);
            i++;
        }
        return maxCount;
    }
}