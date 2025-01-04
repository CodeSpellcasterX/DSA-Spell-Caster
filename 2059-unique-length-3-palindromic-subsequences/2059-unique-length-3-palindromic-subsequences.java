class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        for(int i = 97; i <= 122; i++) {
            char alphabet = (char)i;
            int start = -1;
            int end = s.length();
            for (int j=0;j<s.length();j++) {
                if(s.charAt(j)==alphabet && end == s.length()) {
                    start = j;
                    end = j;
                } else if (s.charAt(j)==alphabet) {
                    end = j;
                }
            }

            HashSet<Character> unique = new HashSet<>();
            if(start!=-1) {
                for(int k = start+1;k<end;k++) {
                    unique.add(s.charAt(k));
                }
            }
            count+=unique.size();
        }
        return count;
    }
}