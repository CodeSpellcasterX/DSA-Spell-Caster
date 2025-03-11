class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0;

        for(int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            while (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            length = Math.max(length, j-i+1);
        }
        return length;
    }
}