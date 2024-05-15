class Solution {
    public void rotate(int[] nums, int k) {
        int finalrotation = k % nums.length;
        rotateInternal(nums, 0, nums.length - finalrotation - 1);
        rotateInternal(nums, nums.length - finalrotation, nums.length - 1);
        rotateInternal(nums, 0, nums.length - 1);
    }

    void rotateInternal(int[] nums, int s, int e) {
    int i = s;
    int k = e;
    while(i < k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
        i++;
        k--;
    }
}
}