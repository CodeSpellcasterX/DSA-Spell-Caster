class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        int i = 0;
        while(i<arr.length) {
            if(arr[i]=='(') {
                st.push(i);
            } else if(arr[i]==')') {
                if(!st.isEmpty() && arr[st.peek()]=='(') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
            i++;
        }

        StringBuilder str = new StringBuilder();
        i = 0;
        while(st.size()>0) {
            arr[st.pop()] = '.';
        }

        while(i<s.length()) {
            if(arr[i]!='.') {
                str.append(arr[i]);
            }
            i++;
        }
        return str.toString();
    }
}