class Solution {
    public int maxDepth(String s) {
        int maxCount = -0;
        int count = 0;
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i)=='(') {
                count++;
                maxCount = Math.max(count, maxCount);
            } else if(s.charAt(i)==')') {
                count--;
            }
            i++;
        }
        return maxCount;
    }
}