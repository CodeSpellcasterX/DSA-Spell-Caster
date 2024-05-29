class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;        
    }

    private int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                idx = mid;
                if (isSearchingLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return idx;
    }

}

// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int first = Integer.MAX_VALUE;
//         int last = -1;
        
//         int i = 0;
//         int j = nums.length-1;
//         while(i<=j) {
//             int mid = i + (j - i) / 2;
//             if(nums[mid] > target) {
//                 j = mid-1;
//             } else if(nums[mid] < target) {
//                 i=mid+1;
//             } else {
//                 last = mid+1;
//                 i=mid+1;
//             }
//         }

//         while(i<=j) {
//             int mid = (i+j)/2;
//             if(nums[mid] > target) {
//                 j = mid-1;
//             } else if(nums[mid] < target) {
//                 i=mid+1;
//             } else {
//                 first = mid-1;
//                 j=mid-1;
//             }
//         }
//         if(first==Integer.MAX_VALUE) {
//             first = -1;
//         }
//         return new int[] {first, last};
//     }
// }