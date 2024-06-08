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
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        
        int ans = 0;
        int i = 0;
        int ret = -1;
        while( i < arr.length) {
            int j = 0;
            int k = arr[0].length-1;
            int firstIndex = Integer.MAX_VALUE;
            while(j<=k) {
                int mid = j + (k-j)/2;
                
                if(arr[i][mid]==1) {
                    firstIndex = mid;
                    k = mid -1;
                } else {
                    j = mid + 1;
                }
            }
            
            if(arr[0].length - firstIndex > ans) {
                ans = arr[0].length - firstIndex;
                ret = i;
            }
            i++;
        }
        
        return ret;
    }
}