class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {  // ✅ Process left to right
            int ast = asteroids[i];

            // Collision condition
            while (!st.isEmpty() && ast < 0 && st.peek() > 0) {  
                int top = st.peek();
                
                if (Math.abs(ast) > top) {  // Current asteroid destroys stack top
                    st.pop();
                    continue; // Keep checking collisions
                } else if (Math.abs(ast) == top) {  // Both asteroids destroy each other
                    st.pop();
                }
                ast = 0; // Mark asteroid as destroyed
            }

            if (ast != 0) { // Only push surviving asteroids
                st.push(ast);
            }
        }

        // Convert stack to array
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}
