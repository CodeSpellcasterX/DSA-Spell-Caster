class Solution {
    public long mostPoints(int[][] questions) {
        long ans = 0;
        long[] max = new long[questions.length];
        Arrays.fill(max, -1);
        return answer(questions, 0, max);
    }

    public long answer(int[][] questions, int i, long[] max) {
        if(i >= questions.length) {
            return 0;
        }
        if(max[i]!=-1) {
            return max[i];
        }
        
        long first = questions[i][0] + answer(questions, i + questions[i][1] + 1, max);
        long second = answer(questions, i+1, max);

        return max[i] = Math.max(first, second);
    }
}