class Solution {
    public int maxProduct(int[] nums) {
        int pref = 1;
        int suf = 1;
        int ans = Integer.MIN_VALUE;
        int i = 0;
        while(i < nums.length) {
            pref = pref * nums[i];
            suf = suf * nums[nums.length-1-i];

            ans = Math.max(ans, Math.max(pref, suf));

            if(pref==0) {
                pref = 1;
            } else if (suf == 0) {
                suf = 1;
            }

            i++;
        }

        return ans;
    }
}