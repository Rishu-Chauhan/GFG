//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) {
       int n=arr.length;
       int sum=0;
       
       for(int i=0;i<n;i++){
           sum +=arr[i];
       }
       if(sum % 2!=0){
           return false;
       }
       return equalSum(arr,sum/2,n);
        
    }
    private static boolean equalSum(int arr[],int sum,int n){
        boolean t[][]=new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
               if(i==0){
                   t[i][j]=false;
               }
               if(j==0){
                   t[i][j]=true;
               }
            }
            
        }
          for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
               if(arr[i-1]<=j){
                   t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
               }
               else{
                   t[i][j]=t[i-1][j];
               }
            }
          }
          return t[n][sum];
    }
}