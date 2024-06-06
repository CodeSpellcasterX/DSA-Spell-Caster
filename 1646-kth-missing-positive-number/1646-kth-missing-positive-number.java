class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int i = 1;
        int kk = 0;
        while(count < k) {
            if(kk>=arr.length){
                count++;
            } else if(i!=arr[kk]){
                count++;
            } else {
                kk++;
            }
            i++;
        }
        return i-1;
    }
}