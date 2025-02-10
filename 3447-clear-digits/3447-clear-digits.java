class Solution {
    public String clearDigits(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                st.push(s.charAt(i));
            } else {
                st.pop();
            }
            i++;
        }

        while(!st.isEmpty()) {
            str.insert(0, st.pop());
        }
        return str.toString();
    }
}