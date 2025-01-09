class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for(int i = 0; i < words.length; i++) {
            if(pref.length() > words[i].length()) {
                continue;
            }

            boolean isMatched = true;
            for(int j = 0; j < pref.length(); j++) {
                if(words[i].charAt(j) != pref.charAt(j)) {
                    isMatched = false;
                    break;
                }
            }

            if(isMatched) {
                count++;
            }
        }

        return count;
    }
}