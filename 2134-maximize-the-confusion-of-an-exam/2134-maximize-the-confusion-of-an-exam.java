class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutive(answerKey, k, 'T'), maxConsecutive(answerKey, k, 'F'));
    }

    private int maxConsecutive(String answerKey, int k, char toMax) {
        int left = 0, right = 0, otherC = 0, maxLen = 0;

        while (right < answerKey.length()) {
            if (answerKey.charAt(right) != toMax) {
                otherC++;
            }

            while (otherC > k) { 
                if (answerKey.charAt(left) != toMax) {
                    otherC--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++; // Always move right
        }
        return maxLen;
    }
}