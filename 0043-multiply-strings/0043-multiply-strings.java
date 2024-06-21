class Solution {
    public String multiply(String num1, String num2) {
        int[] ans = new int[num1.length()+num2.length()];
        
        for(int i = num2.length()-1;i>=0;i--){
            for(int j = num1.length()-1;j>=0;j--){
                int idx1 = i+j;
                int idx2 = i+j+1;
                
                int val = (num1.charAt(j)-'0')*(num2.charAt(i)-'0');
                val = val + ans[idx2];
                
                int rem = val%10;
                int quo = val/10;
                
                ans[idx1]+=quo;
                ans[idx2]=rem;
                
        //  for(int a =0;a<ans.length;a++){
        //     System.out.print(ans[a]+" ");
        // }
        //         System.out.println();
             }
        }

        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ans.length;i++){
            if(sb.length()==0 && ans[i]==0){
                continue;
            }
            
            sb.append(ans[i]);
        }
        
        if(sb.length()==0){
            return "0";
        }
        
        return sb.toString();
    }
}