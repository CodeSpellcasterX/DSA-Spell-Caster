class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) {
            return false;
        }
        if(s.length() == k) {
            return true;
        }

        int[] charArray = new int[26];

        for(int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i)-'a']++;
        }

        int countOdd = 0;
        int countEvenPair = 0;
        for(int i : charArray) {
            if(i%2==1) {
                countOdd++;
            } 
            countEvenPair = countEvenPair + i/2;
        }
        
        if(countOdd > k) {
            return false;
        } 

        return true;
    }
}