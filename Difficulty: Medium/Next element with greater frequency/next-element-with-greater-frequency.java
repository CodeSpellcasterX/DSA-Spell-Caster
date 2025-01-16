//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[arr.length];
        for(int i = 0; i< answer.length;i++) {
            answer[i] = -1;
        }
        st.push(arr.length-1);
        for(int i = arr.length-2;i>=0;i--) {
            int top = st.peek();
            while (!st.isEmpty() && map.get(arr[st.peek()]) <= map.get(arr[i])) {
                st.pop();
            }

            // If stack is not empty, the top element is the next greater frequency
            if (!st.isEmpty()) {
                answer[i] = arr[st.peek()];
            }
            st.push(i);
        }
        return answer;
    }
}

