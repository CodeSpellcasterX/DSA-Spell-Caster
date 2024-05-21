class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        int total = matrix.length*matrix[0].length;
        Integer ans[] = new Integer[total];
        int p = 0;
        int j = 0;
        while(p < total) {
            if(j==0) {
                int k = left;
                while(k <= right) {
                    ans[p] = matrix[top][k];
                    k++;
                    p++;
                }
                top++;
                j=1;
            } else if(j==1){
                int k = top;
                while(k <= bottom) {
                    ans[p] = matrix[k][right];
                    k++;
                    p++;
                }
                right--;
                j=2;
            } else if(j==2){
                int k = right;
                while(k>=left) {
                    ans[p] = matrix[bottom][k];
                    k--;
                    p++;
                }
                bottom--;
                j=3;
            } else {
                int k = bottom;
                while(k>=top) {
                    ans[p] = matrix[k][left];
                    p++;
                    k--;
                }
                left++;
                j=0;
            }
        }
        return Arrays.asList(ans);
    }
}