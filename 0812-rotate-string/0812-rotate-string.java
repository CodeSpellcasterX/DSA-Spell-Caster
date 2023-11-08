class Solution {
    public boolean rotateString(String s, String goal) {
        s = s.concat(s);
        return s.contains(goal) && (goal.length()==(s.length()/2));
    }
}