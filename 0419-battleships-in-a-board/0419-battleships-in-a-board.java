class Solution {
    public int countBattleships(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i =0 ;i<grid.length;i++) {
            for(int j = 0; j < grid[0].length;j++) {
                if(grid[i][j]=='X' && !vis[i][j]) {
                   bfs(grid, vis, i, j);
                   max = max + 1;
                }
            }
        }
        return max;
    }

    private void bfs(char[][] grid, boolean[][] vis, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{i, j});

        int[] rowArray = {-1, 0, +1, 0};
        int[] colArray = {0, +1, 0, -1};

        vis[i][j] = true;

        while(!q.isEmpty()) {
            int[] poll = q.remove();
            int nodeRow = poll[0];
            int nodeCol = poll[1];

            for(int k = 0; k < rowArray.length; k++) {
                int newRow = nodeRow + rowArray[k];
                int newCol = nodeCol + colArray[k];

                if(isValid(newRow, newCol, grid.length, grid[0].length) && grid[newRow][newCol]=='X' && !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    private boolean isValid(int row, int col, int mr, int mc) {
        if(row < 0 || row >= mr || col < 0 || col >= mc) {
            return false;
        }
        return true;
    }
}