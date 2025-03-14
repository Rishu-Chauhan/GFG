//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int coins[], int sum) {
      int n=coins.length;
      int t[][]=new int[n+1][sum+1];
      for(int i=0;i<n+1;i++){
          for(int j=0;j<sum+1;j++){
              if(j==0){
                  t[i][j]=1;
              }
              if(i==0){
                  t[i][j]=0;
              }
          }
      }
      for(int i=1;i<n+1;i++){
          for(int j=1;j<sum+1;j++){
              if(coins[i-1]<=j){
                  t[i][j]=t[i][j-coins[i-1]]+t[i-1][j];
              }
              else{
                  t[i][j]=t[i-1][j];
              }
          }
      }
      return t[n][sum];
    }
}