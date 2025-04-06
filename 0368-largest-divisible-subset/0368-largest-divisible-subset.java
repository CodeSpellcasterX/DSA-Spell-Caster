class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
       int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        Map<String, List<Integer>> memo = new HashMap<String, List<Integer>>();
        return solveMemoization(0, -1, n, nums, memo); 
    }

    private List<Integer> solveMemoization(int index, int prevIndex, 
        int n, int[] nums, Map<String, List<Integer>> memo) {
        // Base Case
        if (index == n) {
            return new ArrayList<Integer>();
        }
        String key = index + "-" + prevIndex;
        // Memoization Check
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // Recursion Calls
        // nottake
        List<Integer> nottake = 
            solveMemoization(index + 1, prevIndex, n, nums, memo); // explore possibilities
        // take
        List<Integer> take = new ArrayList<Integer>();
        if (prevIndex == -1 || nums[index] % nums[prevIndex] == 0) { // divisible subset condition
            take.add(nums[index]);
            take.addAll(solveMemoization(index + 1, index, n, nums, memo));
        }
        List<Integer> result = take.size() > nottake.size() ? take : nottake;
        memo.put(key, result);
        return result;
    }

}