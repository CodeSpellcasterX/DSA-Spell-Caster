class Solution {
    public int[] minOperations(String boxes) {
        char[] charArray = boxes.toCharArray();

        int[] ans = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++) {
            int ansVariable = 0;
            for(int k = 0; k < i; k++) {
                if(charArray[k] == '1')
                    ansVariable = ansVariable + (i-k);
            }
            for(int k = i+1; k < boxes.length(); k++) {
                if(charArray[k] == '1')
                    ansVariable = ansVariable + (k-i);
            }
            ans[i] = ansVariable;
        }

        return ans;

    }
}