class Solution {
    public List<Integer> partitionLabels(String S) {
        int partition = 0;
        int[] arr = new int[26];
        
        for(int i=0;i<S.length();i++){
            arr[S.charAt(i)-'a'] = i;
        }
        
        ArrayList<Integer> ans =  new ArrayList<>();
        int j = 0 ;
        for(int i =0;i<S.length();i++){
            if(arr[S.charAt(i)-'a']>partition){
                partition = arr[S.charAt(i)-'a'];
            }
            
            if(i==partition){
                ans.add(i-j+1);
                j=i+1;
            }
        }
        return ans;
    }
}