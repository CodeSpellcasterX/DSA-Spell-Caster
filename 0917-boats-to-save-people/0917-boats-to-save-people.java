class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0;
        int h = people.length-1;
        Arrays.sort(people);
        int count=0;
        while(l<=h){
            if(people[l]+people[h]>limit){
                h--;
            }else{
                l++;
                h--;
            }
            count++;
        }
      
        return count;
    }
}