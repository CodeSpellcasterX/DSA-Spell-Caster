class Solution {
    public int maximumCandies(int[] candies, long k) {
        int answer = 0;
        int low = 1;
        int high = 0;
        int i = 0;
        while(i < candies.length) {
            high = Math.max(high, candies[i]);
            i++;
        }

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(checkIfPossible(mid, k, candies)) {
                low = mid + 1;
                answer = mid;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private boolean checkIfPossible(int mid, long k, int[] candies) {
        long count = 0;

        for(int i = 0; i < candies.length; i++) {
            count = count + (candies[i])/mid;
            if(count>=k) {
                return true;
            }
        }
        return false;
    }
}