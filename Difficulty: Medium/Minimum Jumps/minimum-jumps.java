//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
 int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] == 0) return -1; 

        int totJump = 0, dest = n - 1, covered = 0, lastJumpIdx = 0;

        for (int i = 0; i < n; i++) {
            covered = Math.max(covered, i + arr[i]);

            if (i == lastJumpIdx) {
                if (covered == i) return -1; 
                lastJumpIdx = covered;
                totJump++;
                if (covered >= dest) return totJump;
            }
        }
        return -1;
        
    }
}