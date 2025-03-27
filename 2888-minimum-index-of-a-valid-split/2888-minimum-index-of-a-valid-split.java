class Solution {
    public int minimumIndex(List<Integer> nums) {

        int n = nums.size();
        
        // Step 1: Find the dominant element using Boyer-Moore Voting Algorithm
        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Validate if candidate is the dominant element
        int totalCount = 0;
        for (int num : nums) {
            if (num == candidate) totalCount++;
        }
        if (totalCount * 2 <= n) return -1;


        int prefixCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == candidate) prefixCount++;
            if (prefixCount * 2 > (i + 1) && (totalCount - prefixCount) * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;



        // int n = nums.size();
        // int[] prefix = new int[nums.size()];
        // Arrays.fill(prefix, -1);
        // HashMap<Integer, Integer> mappre = new HashMap<>();
        // int[] suffix = new int[nums.size()];
        // Arrays.fill(suffix, -1);
        // HashMap<Integer, Integer> mapsuf = new HashMap<>();
        // int countpre = 0;
        // int countsuf = 0;
        // int currentpre = 0;
        // int currentsuf = 0;
        // for(int i = 0; i < nums.size(); i++) {
        //     if(countpre==0) {
        //         countpre = 1;
        //         currentpre = nums.get(i);
        //     } else {
        //         if(currentpre == nums.get(i)) {
        //             countpre++;
        //         } else {
        //             countpre--;
        //         }
        //     }

        //     if(countsuf==0) {
        //         countsuf = 1;
        //         currentsuf = nums.get(n - 1 - i);
        //     } else {
        //         if(currentsuf == nums.get(n - 1 - i)) {
        //             countsuf++;
        //         } else {
        //             countsuf--;
        //         }
        //     }
            
        //     mappre.put(currentpre, mappre.getOrDefault(currentpre, 0) + 1);
        //     mapsuf.put(currentsuf, mapsuf.getOrDefault(currentsuf, 0) + 1);
        //     if(mappre.get(currentpre) > i/2) {
        //         prefix[i] = currentpre;
        //     }
        //     if(mapsuf.get(currentsuf) > i/2) {
        //         suffix[n- 1- i] = currentsuf;
        //     }
        // }

        // for(int i = 0; i < nums.size(); i++) {
        //     if(prefix[i]==suffix[i]) {
        //         return i;
        //     }
        // }

        // return -1;
    }
}