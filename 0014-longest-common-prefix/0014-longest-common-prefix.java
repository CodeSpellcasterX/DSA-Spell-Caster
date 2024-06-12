class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        int k =Integer.MAX_VALUE;
        if(strs.length<=1){
            if(strs.length==0){
                return ans;
            }else{
                return strs[0];
            }
        }
        for(int i=0;i<strs.length-1;i++){
            int count=0;
            String one = strs[i];
            String two = strs[i+1];
            int j =0;
            while(j<one.length()&&j<two.length()){
                if(one.charAt(j)!=two.charAt(j)){
                    break;
                }
                j++;
                count++;
            }
            if(count<k){
                k= count;
            }  
        }
        
        ans = strs[0].substring(0,k);
        return ans;
    }
}
