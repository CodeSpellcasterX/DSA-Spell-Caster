class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int c1 = 0;
        int cn1 = 0;
        int c2 = 0;
        int cn2 = 0;

        while(i<nums.length) {
            if (nums[i]==c1) {
                cn1++;
            } else if(nums[i]==c2) {
                cn2++;
            } else if(cn1==0){
                cn1++;
                c1 = nums[i];
            } else if(cn2==0) {
                cn2++;
                c2 = nums[i];
            } else {
                cn1--;
                cn2--;
            }
            i++;
        }

        int k = 0;
        int count1 = 0;
        int count2 = 0;
        while(k < nums.length) {
            if(nums[k]==c1) {
                count1++;
            } else if (nums[k]==c2) {
                count2++;
            }
            k++;
        }

        if(count1>nums.length/3) {
            ans.add(c1);
        } 
        if (count2>nums.length/3) {
            ans.add(c2);
        }

        return ans;
    }
}