class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int i = 0;
        int j = arr.length-1;
        int row = 0;
        while(i<=j) {
            int mid = i + (j-i)/2;
            row  = mid;
            if(arr[mid][0]==target) {
                return true;
            } else if(arr[mid][0]<target) {
                if(arr[mid][arr[mid].length-1] >= target){
                    break;
                }
                i = mid + 1;
            } else {
                if(arr[mid][arr[mid].length-1] <= target){
                    break;
                }
                j = mid - 1;
            }
        }

        i = 0;
        j = arr[row].length-1;
        while(i<=j) {
            int mid = i + (j-i)/2;
            if(arr[row][mid]==target) {
                return true;
            } else if(arr[row][mid]<target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;

    }
}