class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prevC = image[sr][sc];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        boolean[][] vis = new boolean[image.length][image[0].length];
        int[] rowP = {-1, 0, 1, 0};
        int[] colP = {0, 1, 0, -1};
        while(q.size()>0) {
            int[] poll = q.remove();
            int i = poll[0];
            int j = poll[1];
            if(!vis[i][j] && image[i][j]==prevC) {
                vis[i][j] = true;
                image[i][j] = color;
                for(int k = 0 ; k< rowP.length; k++) {
                    int newR = rowP[k]+i;
                    int newC = colP[k]+j;

                    if(isValid(newR, newC, image.length, image[0].length) && !vis[newR][newC]) {
                        q.add(new int[]{newR, newC});
                    }
                }
            }
        }
        return image;
    }

    private boolean isValid(int i, int j, int mr, int mc) {
        if(i<0 || i >= mr || j<0 || j>=mc) {
            return false;
        }
        return true;
    }
}