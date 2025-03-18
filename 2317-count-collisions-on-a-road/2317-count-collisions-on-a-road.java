class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();
        st.push(directions.charAt(0));
        int ans = 0;
        for(int i = 1; i< directions.length() ; i++) {
            Character ch = directions.charAt(i);

            if(!st.empty() && ch == 'L' && st.peek()=='R') {
                ans = ans + 2;
                ch = 'S';
                st.pop();
            } else if (!st.empty() && ch == 'L' && st.peek()=='S') {
                ans = ans + 1;
                ch = 'S';
                st.pop();
            }

            while (!st.isEmpty() && st.peek() == 'R' && ch == 'S') {
                st.pop();
                ans += 1;
            }
            st.push(ch);
        }
        return ans;
    }
}