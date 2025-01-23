class Solution {
    public int countServers(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        int totalCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length;j++) {
                if(grid[i][j]==1) {
                    row[i]++;
                    col[j]++;
                    totalCount++;
                }
            }
        }

        int yesCount = 0;

        for(int i = 0; i < row.length; i++) {
            if(row[i]==1) {
                int colNum = 0;
                for(int j = 0; j < col.length; j++) {
                    if(grid[i][j]==1 && col[j]==1) {
                        yesCount++;
                    }
                }
            }
        }

        return totalCount - yesCount;
    }
}