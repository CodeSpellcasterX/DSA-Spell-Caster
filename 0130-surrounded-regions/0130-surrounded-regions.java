class Solution {
    public void solve(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i]=='O') {
                bfs(board, vis, 0, i);
            }
        }
        for(int i = 0; i < board.length; i++) {
            if(board[i][board[0].length-1]=='O') {
                bfs(board, vis, i, board[0].length-1);
            }
        }
        for(int i = 0; i < board[0].length; i++) {
            if(board[board.length-1][i]=='O') {
                bfs(board, vis, board.length-1, i);
            }
        }
        for(int i = 0; i < board.length; i++) {
            if(board[i][0]=='O') {
                bfs(board, vis, i, 0);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O') {
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, boolean[][] vis, int i, int j) {

        Queue<int[]> q = new ArrayDeque<>();

        int[] rowArray = {-1, 0, +1, 0};
        int[] colArray = {0, +1, 0, -1};

        q.add(new int[]{i, j});
        vis[i][j] = true;

        while(!q.isEmpty()) {
            int[] poll = q.remove();
            int row = poll[0];
            int col = poll[1];
            board[row][col] = 'A';
            for(int k = 0; k < rowArray.length; k++) {
                int newRow = row + rowArray[k];
                int newCol = col + colArray[k];

                if(isValid(newRow, newCol, vis.length, vis[0].length) && !vis[newRow][newCol] && board[newRow][newCol]=='O') {
                    q.add(new int[]{newRow, newCol});
                    vis[newRow][newCol] = true;
                }
            }
        }
    }

    private boolean isValid(int row, int col, int mr, int mc) {
        if(row < 0 || col < 0 || row >= mr || col >= mc) {
            return false;
        }
        return true;
    }
}