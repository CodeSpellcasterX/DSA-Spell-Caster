class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;
        int i = 0;
        while(i < s.length()-1) {
            char ch = s.charAt(i);
            if(m.get(ch) < m.get(s.charAt(i+1))) {
                ans = ans - m.get(ch);
            } else {
                ans = ans + m.get(ch);
            }
            i++;
        }
        ans = ans + m.get(s.charAt(s.length()-1));
        return ans;
    }
}