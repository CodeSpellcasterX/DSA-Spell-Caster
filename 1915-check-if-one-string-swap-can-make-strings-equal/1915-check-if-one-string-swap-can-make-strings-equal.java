class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int length = 0;
        int i = 0;
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        while(i < s1.length()) {
            if(s1.charAt(i) != s2.charAt(i)) {
                length++;
                set1.add(s1.charAt(i));
                set2.add(s2.charAt(i));
            }
            i++;
        }
        return (length == 2 || length == 0) && set1.equals(set2);
    }
}