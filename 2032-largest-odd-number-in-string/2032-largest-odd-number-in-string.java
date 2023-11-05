class Solution {
    public String largestOddNumber(String num) {
        int i = num.length()-1;
        while(i>=0 && num.charAt(i)%2==0) {
            i--;
        }
        if(i==-1) {
            return "";
        }
        return num.substring(0,i+1);
    }
}