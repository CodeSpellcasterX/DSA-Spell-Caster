//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        int i = 0;
        int j = m;
        int ans = -1;
        while(i<=j) {
            int mid = i + (j-i)/2;
            if(calc(n,mid, m) == m){
                return mid;
            } else if (calc(n,mid, m) == -1) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }
    
    public int calc(int n, int m, int anss) {
        long ans = 1;
        for(int i=1;i<=n;i++){
            ans = ans * m;
            if(ans > anss) {
                return -1;
            }
        }
        return (int)ans;
    }
}