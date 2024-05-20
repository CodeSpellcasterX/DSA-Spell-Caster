class Solution {
    public void rotate(int[][] matrix) {
        int i = 0;
        while(i < matrix.length) {
            int j = 0;
            while(j < i) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                j++;
            }
            i++;
        }
        i = 0;

        while(i<matrix.length) {
            reverse(matrix[i]);
            i++;
        }

    }

    public void reverse(int[] arr) {
        int i = 0;
        int j = arr.length-1;

        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}