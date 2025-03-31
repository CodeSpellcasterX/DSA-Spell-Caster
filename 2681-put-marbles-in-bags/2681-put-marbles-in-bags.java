class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k>=weights.length){
            return 0;
        }
        List<Integer> listu = new ArrayList<>();
        for (int i = 0; i < weights.length - 1; i++) {
            listu.add(weights[i] + weights[i + 1]);
        }  
        Collections.sort(listu);
        long max=0;
        long min=0;
        for(int i=0;i<k-1;i++){
          max+=listu.get(listu.size()-1-i);
          min+=listu.get(i);
        }
        return max-min;
    }
}