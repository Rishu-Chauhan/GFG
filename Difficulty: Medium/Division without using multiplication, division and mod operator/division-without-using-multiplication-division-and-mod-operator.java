//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String S[] = br.readLine().split(" ");

            long a = Long.parseLong(S[0]);

            long b = Long.parseLong(S[1]);

            Solution ob = new Solution();

            System.out.println(ob.divide(a, b));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long divide(long dividend, long divisor) {
        // code here
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
      
        return dividend/ divisor;
    }
}