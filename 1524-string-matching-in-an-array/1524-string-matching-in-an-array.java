class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i=0;i<words.length;i++){
            String check = words[i];
            
            for(int j=0;j<words.length;j++){
                if(j==i){
                    continue;
                }else{
                    if(words[j].contains(check)){
                        ans.add(check);
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}