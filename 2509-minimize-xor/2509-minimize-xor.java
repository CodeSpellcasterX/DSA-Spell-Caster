class Solution {
    public int minimizeXor(int num1, int num2) {
        int result = num1;

        int targetSetBit = Integer.bitCount(num2);
        int currentSetBit = Integer.bitCount(num1);

        int currentBit = 0;
        while(currentSetBit < targetSetBit) {
            boolean ifCurrentSetOrNot = (result & (1 << currentBit)) != 0;
            if(!ifCurrentSetOrNot) {
                result = result | (1 << currentBit);
                currentSetBit++;
            }
            currentBit++;
        }

        while(currentSetBit > targetSetBit) {
            boolean ifCurrentSetOrNot = (result & (1 << currentBit)) !=0;
            if(ifCurrentSetOrNot) {
                result = result & ~(1 << currentBit);
                currentSetBit--;
            }
            currentBit++;
        }

        return result;
    }
}