class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        
        // Step 1: Find lower bound (first index >= x)
        int left = 0, right = n - 1;
        int idx = n; // default if all elements < x
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Step 2: Two pointers
        int l = idx - 1;
        int r = idx;

        List<Integer> result = new ArrayList<>();

        while (k-- > 0) {
            if (l < 0) {
                result.add(arr[r++]);
            } else if (r >= n) {
                result.add(0, arr[l--]); // add at front
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                result.add(0, arr[l--]); // smaller comes first
            } else {
                result.add(arr[r++]);
            }
        }

        return result;
    }
}