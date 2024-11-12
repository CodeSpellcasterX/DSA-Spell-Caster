// class Solution {
//     public String decodeString(String s) {
//         StringBuilder ans = new StringBuilder();
//         StringBuilder subAns = new StringBuilder();
//         int i = 0;
//         Stack<String> st = new Stack<>();
//         int openingCount = 0;
//         while(i < s.length()) {
//             char ch = s.charAt(i);
//             if(ch==']') {
//                 StringBuilder bdaAnswer = new StringBuilder();
//                 StringBuilder chottaAnswer = new StringBuilder();
//                 while(st.size()>0 && st.peek()!="[") {
//                     chottaAnswer.insert(0, st.pop());
//                 }
//                 st.pop();
//                 openingCount--;
//                 int iterate = (st.pop().charAt(0) - '0');
//                 for (int k = 0; k < iterate; k++) {
//                     bdaAnswer.append(chottaAnswer);
//                 }
                
//                 if(openingCount>0) {
//                     st.push(bdaAnswer.toString());
//                 } else {
//                     ans.append(bdaAnswer);
//                 }
//             } else {
//                 if(ch=='[') {
//                     openingCount++;
//                 }
//                 st.push(ch + "");
//             }
//             i++;
//         }
//         return ans.toString();
//     }
// }


class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                // Step 1: Retrieve the substring inside the brackets
                StringBuilder substr = new StringBuilder();
                while (stack.peek() != '[') {
                    substr.insert(0, stack.pop());
                }
                stack.pop(); // Pop the '['
                
                // Step 2: Retrieve the number
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k.insert(0, stack.pop());
                }
                int repeatCount = Integer.parseInt(k.toString());
                
                // Step 3: Repeat the substring and push back to stack
                String repeatedSubstr = substr.toString().repeat(repeatCount);
                for (char ch : repeatedSubstr.toCharArray()) {
                    stack.push(ch);
                }
            }
        }
        
        // Step 4: Build the final result from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }

}