//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        int pre = 0;
        int ans = 0;
        
        while(i<n) {
            pre = pre+arr[i];
            
            if(pre==0) {
                ans = i+1;
                i++;
                continue;
            }
            if(map.containsKey(pre)) {
                ans = Math.max(ans,i - map.get(pre));
            } else {
                 map.put(pre, i);
            }
            i++;
        }
        
        return ans;
        
    }
}