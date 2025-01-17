class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int finalValue = 0;

        for(int i = derived.length - 1 ; i >= 0; i--) {
            if(derived[i]==0) {
                finalValue = finalValue == 0 ? 0 : 1;
            } else {
                finalValue = finalValue == 0 ? 1 : 0;
            }
        }

        return finalValue == 0;
    }
}