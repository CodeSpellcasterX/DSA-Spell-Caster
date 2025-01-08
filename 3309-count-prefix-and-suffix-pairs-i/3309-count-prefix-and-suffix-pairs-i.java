class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) 
                    count++;
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        if(str1.length() > str2.length()) {
            return false;
        } 
        int j = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(j)) {
                return false;
            }
            j++;
        }

        j = str2.length()-1;
        for(int i = str1.length() - 1; i >= 0; i--) {
            if(str1.charAt(i) != str2.charAt(j)) {
                return false;
            }
            j--;
        }

        return true;
    }
}