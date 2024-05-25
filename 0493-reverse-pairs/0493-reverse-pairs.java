class Solution {

    int ans = 0;
    public int reversePairs(int[] nums) {
        int left  = 0;
        int right = nums.length - 1;
        mergeSort(nums, left, right);
        // for(int i = 0; i<nums.length;i++) {
        //     System.out.println(nums[i]);
        // }
        return ans;
    }

    public void mergeSort(int[] arr, int l, int r) {
        if(l==r) {
            return;
        }
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        validate(arr, l, mid, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r) {
        int x = l;
        int y = mid+1;
        int[] temp = new int[r-l+1];
        int k = 0;

        while(x<=mid && y<=r) {
            if(arr[x] > arr[y]) {
                temp[k]=arr[y];
                y++;
            } else {
                temp[k] = arr[x];
                x++;
            }
            k++;
        }

        while(x<=mid) {
            temp[k] = arr[x];
            x++;
            k++;
        }

        while(y<=r) {
            temp[k] = arr[y];
            y++;
            k++;
        }

        for(int z=0;z<r-l+1;z++) {
            arr[z+l] = temp[z];
        }
    }

    public void validate(int[] arr, int l, int mid, int r) {
        int x = l;
        int y = mid+1;
        while(x <= mid && y <=r) {
            if((long)arr[x] >  2 * (long) arr[y]) {
                ans = ans + (mid-x+1);
                y++;
            } else {
                x++;
            }
        }
    }

}