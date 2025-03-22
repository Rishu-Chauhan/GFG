//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int maxValue(int[] arr) {
        // code here
         int n=arr.length;
      if (arr.length < 2)
      return arr[0];
      int[] skipLastHouse = new int[arr.length - 1];
    int[] skipFirstHouse = new int[arr.length - 1];

    for (int i = 0; i < arr.length - 1; i++) {
      skipLastHouse[i] = arr[i];
      skipFirstHouse[i] = arr[i + 1];
    }

    // Get the loot from both the possibilities
    int lootSkippingLast = robHelper(skipLastHouse);
    int lootSkippingFirst = robHelper(skipFirstHouse);

    // Return the maximum of 2 loots
    return Math.max(lootSkippingLast, lootSkippingFirst);
        }
     int robHelper(int[] arr){
          if (arr.length < 2)
      return arr[0];

    int[] dp = new int[arr.length];

    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);

    for (int i = 2; i < arr.length; i++) {
      dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
    }

    return dp[arr.length - 1];
    }
}
