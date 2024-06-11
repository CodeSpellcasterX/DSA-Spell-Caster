class Solution {
    public String reverseWords(String s) {
        String[] ans = s.trim().split(" ");
        StringBuilder str = new StringBuilder();
        
        for(int i=ans.length-1;i>=0;i--){
            if(!ans[i].trim().isEmpty()){
                str.append(ans[i]);
                str.append(" ");    
            }
        }
        return str.toString().trim();
    }
}