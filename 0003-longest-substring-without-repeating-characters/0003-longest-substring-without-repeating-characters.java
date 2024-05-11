class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while(i < s.length()) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            ans = Integer.max(ans, i-j+1);
            map.put(s.charAt(i), i);
            i++;
        }
        return ans;
    }
}