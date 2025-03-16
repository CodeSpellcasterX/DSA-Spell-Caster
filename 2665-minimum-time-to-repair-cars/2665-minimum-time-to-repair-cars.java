class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = -1;

        for(int i = 0; i < ranks.length ; i++) {
            high = Math.max(high, (long)cars*cars*ranks[i]);
        }

        long ans = high;

        while(low <= high) {
            long mid = low + (high-low)/2;

            if(checkIfPossible(ranks, cars, mid)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean checkIfPossible(int[] ranks, int cars, long mid) {
        long count = 0;

        for (int rank : ranks) {
            count += (long) Math.sqrt(mid / rank);
            if (count >= cars) return true;
        }
        return false;
    }
}