class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int ans = -1;
        int i = 0;
        while(i<bloomDay.length) {
            max = Math.max(max, bloomDay[i]);
            i++;
        }

        i = 0;
        int j = max;

        while(i<=j) {
            int mid = i + (j-i)/2;
            int subans = check(bloomDay, mid, k);
            if(subans >= m) {
                ans = mid;
                j = mid-1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    public int check(int[] arr, int mid, int k) {
        int i = 0;
        int count = 0;
        int subans = 0;
        while(i < arr.length) {
            if(arr[i]<=mid) {
                count++;
            } else {
                count = 0;
            }
            if(count==k) {
                subans++;
                count=0;
            }
            i++;
        }
        return subans;
    }
}