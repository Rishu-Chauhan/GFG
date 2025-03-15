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
      int n=arr.length;
      if(n<2){
          return arr[0];
          
      }
      int skipF[]=new int[n-1];
      int skipL[]=new int[n-1];
      for(int i=0;i<n-1;i++){
          skipF[i]=arr[i+1];
          skipL[i]=arr[i];
      }
      int maxLootFromF=loot(skipF);
        int maxLootFromL=loot(skipL);
        return Math.max(maxLootFromF,maxLootFromL);
    }
    private int loot(int arr[]){
        int n=arr.length;
        if(n<2){
            return arr[0];
            
        }
        int dp[]=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+arr[i],dp[i-1]);
        }
        return dp[n-1];
    }
}
