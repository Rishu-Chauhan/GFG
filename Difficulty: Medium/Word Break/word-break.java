//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary) == 1) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wordBreak(String s, String[] dictionary) {
     
     int n = s.length();
        boolean[] t = new boolean[n + 1];
        t[0] = true;

        
        for (int i = 1; i <= n; i++) {
      
            for (String w : dictionary) {
           
                int start = i - w.length();
                if (start >= 0 && t[start]
                    && s.substring(start,
                                   start + w.length())
                           .equals(w)) {
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n] ? 1:0;
    }
}