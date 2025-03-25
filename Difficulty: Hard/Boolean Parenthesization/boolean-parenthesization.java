//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
   public static boolean evaluate(int b1, int b2, char op) {
        if (op == '&') {
            return (b1 & b2) == 1;
        } else if (op == '|') {
            return (b1 | b2) == 1;
        } else {
            return (b1 ^ b2) == 1;
        }
    }
     public static  int helper(int start, int end, int req, String s, int[][][] dp) {
        if (start == end) {
            return (req == (s.charAt(start) == 'T' ? 1 : 0)) ? 1 : 0;
        }

        if (dp[start][end][req] != -1) return dp[start][end][req];

        int ans = 0;

        for (int k = start + 1; k < end; k += 2) {
            int leftTrue = helper(start, k - 1, 1, s, dp);
            int leftFalse = helper(start, k - 1, 0, s, dp);

            int rightTrue = helper(k + 1, end, 1, s, dp);
            int rightFalse = helper(k + 1, end, 0, s, dp);

            if (evaluate(1, 1, s.charAt(k)) == (req == 1)) {
                ans += leftTrue * rightTrue;
            }
            if (evaluate(1, 0, s.charAt(k)) == (req == 1)) {
                ans += leftTrue * rightFalse;
            }
            if (evaluate(0, 1, s.charAt(k)) == (req == 1)) {
                ans += leftFalse * rightTrue;
            }
            if (evaluate(0, 0, s.charAt(k)) == (req == 1)) {
                ans += leftFalse * rightFalse;
            }
        }

        return dp[start][end][req] = ans;
    }
    static int countWays(String s) {
       int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return helper(0, n - 1, 1, s, dp);
    }
}