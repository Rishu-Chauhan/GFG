//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr));
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    int transitionPoint(int arr[]) {
        // code here
       int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == 1) {
                if (mid == 0 || arr[mid - 1] == 0) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }
        return -1; 
    }
}