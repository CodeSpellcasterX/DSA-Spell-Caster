class Solution {
    public int maxScore(int[] cardScore, int k) {
        int n = cardScore.length;
        int totalSum = 0;
        for (int i = 0; i < k; i++) {
            totalSum += cardScore[i];
        }

        int maxSum = totalSum;
        int rightSum = 0;

        for (int i = 0; i < k; i++) {
            totalSum -= cardScore[k - 1 - i]; 
            rightSum += cardScore[n - 1 - i];
            maxSum = Math.max(maxSum, totalSum + rightSum);
        }

        return maxSum;
    }
}