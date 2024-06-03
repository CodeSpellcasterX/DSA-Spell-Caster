class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i =0;i<piles.length;i++) {
            max = Math.max(max, piles[i]);
        }

        int j = 1;
        int k = max;
        int ans = 0;
        while(j<=k) {
            int mid = j + (k-j)/2;
            int subans = check(piles, mid);
            System.out.println(mid + " " + subans);
            if(subans>0 && subans<=h) {
                ans = mid;
                k = mid-1;
            } else {
                j=mid+1;
            }
        }
        return ans;
    }

    public int check(int[] arr, int mid) {
        int ans = 0;
        int i = 0;
        while(i<arr.length) {
            if(arr[i]%mid==0) {
                ans = ans + (arr[i]/mid);
            } else {
                ans = ans + (arr[i]/mid) + 1;
            }
            i++;
        }
        return ans;
    }
}