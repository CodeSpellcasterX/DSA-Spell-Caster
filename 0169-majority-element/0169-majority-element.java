class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        int i = 1;
        while (i<nums.length) {
            if (nums[i]== num) {
                count++;
            } else {
                if(count==0) {
                    count++;
                    num = nums[i];
                } else {
                    count--;
                }
            }
            i++;
        }
        return num;
    }
}