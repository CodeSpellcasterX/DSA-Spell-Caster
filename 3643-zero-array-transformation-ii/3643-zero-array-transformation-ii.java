class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int first = 0;
        int end = queries.length;
        int ans = -1;

        while (first <= end) {
            int mid = (end + first) / 2;
            boolean isZeroFound = isZero(nums, queries, mid);
            if (isZeroFound) {
                ans = mid; 
                end = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return ans;
    }

    private boolean isZero(int[] nums, int[][] queries, int k) {
        int[] prefixArray = new int[nums.length + 1];

        for (int i = 0; i < k; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int val = queries[i][2];

            prefixArray[left] += val; 
            prefixArray[right + 1] -= val;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += prefixArray[i];
            if (nums[i] - sum > 0) { 
                return false;
            }
        }
        return true;
    }
}