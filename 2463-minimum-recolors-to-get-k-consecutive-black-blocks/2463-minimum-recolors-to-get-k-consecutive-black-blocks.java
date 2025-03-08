class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minNum = 0;
        for(int i = 0; i < k; i++) {
            if(blocks.charAt(i)=='W') {
                minNum++;
            }
        }
        int count = minNum;
        int i = 1;
        for(int j = k; j < blocks.length();j++) {
            if(blocks.charAt(j)=='W') {
                count++;
            }
            if(blocks.charAt(i-1)=='W') {
                count--;
            }
            minNum = Math.min(minNum, count);
            i++;
        }
        return minNum;
    }
}