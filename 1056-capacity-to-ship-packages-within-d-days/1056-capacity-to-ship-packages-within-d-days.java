class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int i = Integer.MIN_VALUE;
        int j = 0;
        for(int k = 0;k<weights.length;k++) {
            j = j + weights[k];
            if(weights[k]>i) {
                i = weights[k];
            }
        }
        int ans = 0;
        while(i<=j) {
            int mid = i + (j-i)/2;
            int csum =0;
            int reqd = 1;
            for(int kk=0;kk<weights.length;kk++){
                if(csum+weights[kk]>mid){
                    reqd++;
                    csum=0;
                }
                csum=csum+weights[kk];
            }
            if(reqd>days){
                i=mid+1;
            }else{
                j = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
}