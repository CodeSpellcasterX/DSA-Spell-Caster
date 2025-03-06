class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[grid.length*grid.length];
        for(int i = 0; i < grid.length;i++) {
            for(int j = 0; j < grid[0].length;j++) {
                ans[grid[i][j]-1]++;
            }
        }

        int[] ansFinal = new int[2];
        for(int i = 0; i < grid.length*grid.length; i++) {
            if(ans[i]==0) {
                ansFinal[1] = i+1;
            }
            if(ans[i]==2) {
                ansFinal[0] = i+1;
            }
        }
        return ansFinal;
    }
}