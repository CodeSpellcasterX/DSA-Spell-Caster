class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int count = 0;
        int[] countArray = new int[A.length];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        HashSet<Integer> ch = new HashSet<>();

        int i = 0;
        while(i < A.length) {
            int a = A[i];
            int b = B[i];
            setA.add(a);
            setB.add(b);
            
            if(setB.contains(a) && !ch.contains(a)) {
                ch.add(a);
                count++;
            }
            if(setA.contains(b) && !ch.contains(b)) {
                ch.add(b);
                count++;
            }
            countArray[i] = count;
            i++;
        }
        return countArray;
    }
}