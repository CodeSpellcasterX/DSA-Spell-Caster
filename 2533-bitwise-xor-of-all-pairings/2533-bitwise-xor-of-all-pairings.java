class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int nums1L = nums1.length;
        int nums2L = nums2.length;
        int answer = 0;
        if(nums2L % 2 > 0 && nums1L % 2 > 0) {
            for(int i = 0; i < nums1L ; i++) {
                answer = answer ^ nums1[i];
            }
            for(int i = 0; i < nums2L;i++) {
                answer = answer ^ nums2[i];
            }
        } else if (nums1L % 2 > 0) {
            for(int i = 0; i < nums2L;i++) {
                answer = answer ^ nums2[i];
            }
        } else if (nums2L % 2 > 0) {
            for(int i = 0; i < nums1L ; i++) {
                answer = answer ^ nums1[i];
            }
        } 
        return answer;
    }
}