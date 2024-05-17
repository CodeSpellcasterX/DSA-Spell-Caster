class Solution {
    public int maxProfit(int[] prices) {
        
        int minSoFar = Integer.MAX_VALUE;
        int i = 0;
        int ans = 0;

        while (i < prices.length) {
            ans = Integer.max(ans, prices[i] - minSoFar);
            minSoFar = Integer.min(minSoFar, prices[i]);
            i++;
        }
        return ans;
    }
}