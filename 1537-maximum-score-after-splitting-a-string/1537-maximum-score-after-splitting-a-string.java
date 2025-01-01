class Solution {
    public int maxScore(String s) {
        int i = 1;
        int j = s.length()-2;

        int[] leftZeroes = new int[s.length()];
        int[] rightOnes = new int[s.length()];    
        leftZeroes[0] = s.charAt(0) - '0' > 0 ? 0 : 1;
        rightOnes[s.length()-1] = s.charAt(s.length()-1) - '0' > 0 ? 1 : 0;
        while(i < s.length()) {
            int countOfZero = s.charAt(i) - '0' > 0 ? 0 : 1;
            leftZeroes[i] = leftZeroes[i-1] + countOfZero;
            i++;
        } 

        while(j >= 0) {
            int countOfOne = s.charAt(j) - '0' > 0 ? 1 : 0;
            rightOnes[j] = rightOnes[j+1] + countOfOne;
            j--;
        }   

        int max = 0;
        int k = 1;
        while(k < s.length()) {
            max = max > (leftZeroes[k-1] + rightOnes[k]) ? max : (leftZeroes[k-1] + rightOnes[k]);
            k++;
        }
        return max;
    }
}