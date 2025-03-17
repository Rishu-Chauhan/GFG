//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
       int n=arr.length;
       boolean d[][]=new boolean[n+1][sum+1];
       for(int i=0;i<n+1;i++){
           for(int j=0;j<sum+1;j++){
               if(i==0){
                   d[i][j]=false;
               }
               if(j==0){
                   d[i][j]=true;
               }
           }
           
       }
       for(int i=1;i<n+1;i++){
           for(int j=1;j<sum+1;j++){
               if(arr[i-1]<=j){
                   d[i][j]=d[i-1][j-arr[i-1]] || d[i-1][j];
               }
               else{
                   d[i][j]=d[i-1][j];
               }
           }
       }
       return d[n][sum];
    }
}