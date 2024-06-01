//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int i = 0;
        int j = n-1;
        int first = binary(arr, n, x, true);
        int last = binary(arr, n, x, false);
        if(first==-1 && last==-1) {
            return 0;
        }
        return last-first+1;
        
    }
    
    int binary(int[] arr, int n, int x, boolean isFirst) {
        
        int i = 0;
        int j = n-1;
        
        int ans = -1;
        while(i<=j) {
            int mid = (i+j)/2;
            
            if(arr[mid]>x){
                j = mid-1;
            } else if(arr[mid]<x) {
                i = mid+1;
            } else {
                ans = mid;
                if(isFirst) {
                    j = mid - 1;
                } else{
                    i = mid + 1;
                }
            }
        }
        return ans;
    }
}