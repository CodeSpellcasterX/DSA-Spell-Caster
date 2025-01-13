class Solution {
    public int minimumLength(String s) {
        int[] character = new int[26];

        for(int i = 0; i < s.length(); i++) {
            character[s.charAt(i)-'a']++;
        }

        int count = 0;
        for(int i = 0; i < character.length; i++) {
            if(character[i] % 2 == 1) {
                count++;
            } else if (character[i] > 0 && character[i] % 2 == 0) {
                count = count + 2;
            }
        }
        return count;
    }
}