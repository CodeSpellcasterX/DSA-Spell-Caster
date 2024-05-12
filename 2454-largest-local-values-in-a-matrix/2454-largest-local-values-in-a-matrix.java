class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid.length-2];

        int i = 0;
        

        while ( i < ans.length ) {
            int j = 0;
            while( j < ans.length ) {
                for(int x = i; x <= i + 2; x++) {
                    for(int y = j; y <= j + 2 ; y++) {
                        ans[i][j] = Math.max(ans[i][j], grid[x][y]);
                    }
                }
                j++;
            }
            i++;
        }
        return ans;
    }
}