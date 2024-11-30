class Solution {
    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        int i = 1;
        while(i<ratings.length) {
            if(ratings[i]>ratings[i-1]) {
                ans[i] = ans[i-1] + 1;
            }
            i++;
        }
        i = i-2;
        while(i>=0) {
            if(ratings[i] > ratings[i+1]) {
                ans[i] = Math.max(ans[i], ans[i+1]+ 1);
            }
            i--;
        }
        int totalCandies = 0;
        for (int candy : ans) {
            totalCandies += candy;
        }
        return totalCandies;
    }
}