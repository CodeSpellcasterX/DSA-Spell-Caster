class Solution {
    public String countAndSay(int n) {
        
        if(n==1){
            return "1";
        }else if(n==2){
            return "11";
        }else{
            
            String s = "11";
            for(int i=3;i<=n;i++){
                int c=1;
                String ans ="";
                for(int j=1;j<s.length();j++){
                    if(s.charAt(j)!=s.charAt(j-1)){
                        ans = ans+c+s.charAt(j-1);
                        c=1;
                    }else{
                        c++;
                    }
                }
                    ans = ans+c+s.charAt(s.length()-1);
                s=ans;
              
        }
            
            return s;
        
    }
}
}