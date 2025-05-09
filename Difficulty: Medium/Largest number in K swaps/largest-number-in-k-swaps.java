//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        // code here.
         StringBuilder res = new StringBuilder(s);
        setDigit(new StringBuilder(s), 0, res, k);

    
        return res.toString();
    }
    
     static void match(String curr, 
                             StringBuilder result) {
        
       
        if (curr.compareTo(result.toString()) > 0) {
            result.replace(0, result.length(), curr);
        }
    }

  
    static void setDigit(StringBuilder s, 
                        int index, StringBuilder res, int k) {
        
       
        if (k == 0 || index == s.length() - 1) {
            match(s.toString(), res);
            return;
        }

        int maxDigit = 0;

     
        for (int i = index; i < s.length(); i++) {
            maxDigit = Math.max(maxDigit, s.charAt(i) - '0');
        }

     
        if (s.charAt(index) - '0' == maxDigit) {
            setDigit(s, index + 1, res, k);
            return;
        }

        for (int i = index + 1; i < s.length(); i++) {
            
         
            if (s.charAt(i) - '0' == maxDigit) {
              
                char temp = s.charAt(index);
                s.setCharAt(index, s.charAt(i));
                s.setCharAt(i, temp);

                setDigit(s, index + 1, res, k - 1);

                s.setCharAt(i, s.charAt(index));
                s.setCharAt(index, temp);
            }
        }
    }
}