class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] onesRow = new int[grid[0].length];
        int[] onesCol = new int[grid.length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) {
                    onesRow[j]++;
                    onesCol[i]++;
                }
            }
        }

        int[][] diff = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                diff[i][j] = onesRow[j] + onesCol[i] - (grid.length - onesRow[j]) - (grid[0].length - onesCol[i]);
            }
        }

        return diff;
    }
}