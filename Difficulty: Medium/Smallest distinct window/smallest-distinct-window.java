//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        int n = str.length();

      
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }
        int requiredCharCount = uniqueChars.size();

      
        Map<Character, Integer> windowCharCount = new HashMap<>();
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, formed = 0;

        for (int right = 0; right < n; right++) {
            char ch = str.charAt(right);
            windowCharCount.put(ch, windowCharCount.getOrDefault(ch, 0) + 1);

            if (windowCharCount.get(ch) == 1) {
                formed++;
            }

        
            while (formed == requiredCharCount) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = str.charAt(left);
                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (windowCharCount.get(leftChar) == 0) {
                    formed--;
                }
                left++;
            }
        }

        return minLen;
    }
}