class Solution {
    public String removeOuterParentheses(String s) {
        int oc = 0;
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i<s.length()) {
            if(oc==1) {
                if(s.charAt(i)=='(') {
                    ans = ans.append('(');
                } 
            } else if (oc>1) {
                ans = ans.append(s.charAt(i));
            }
            if(s.charAt(i)=='(') {
                oc++;
            } else {
                oc--;
            }
            i++;
        }
        return ans.toString();
    }
}