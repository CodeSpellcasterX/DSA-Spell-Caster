class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        int i = 1;
        while (i<prices.length) {
            min = Math.min(min, prices[i-1]);
            maxProfit = Math.max(maxProfit, prices[i]-min);
            i++;
        }
        return maxProfit;
    }
}