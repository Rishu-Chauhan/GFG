//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        // code here
         int k = arr.length; 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int maxVal = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

      
        for (int i = 0; i < k; i++) {
            minHeap.add(new int[]{arr[i][0], i, 0}); 
            maxVal = Math.max(maxVal, arr[i][0]);
        }

        while (!minHeap.isEmpty()) {
            int[] minElement = minHeap.poll();
            int value = minElement[0], row = minElement[1], col = minElement[2];

          
            if (maxVal - value < end - start) {
                start = value;
                end = maxVal;
            }
  
            if (col + 1 < arr[row].length) {
                minHeap.add(new int[]{arr[row][col + 1], row, col + 1});
                maxVal = Math.max(maxVal, arr[row][col + 1]);
            } else {
                break; 
            }
        }

        
        return new ArrayList<>(Arrays.asList(start, end));
    }
}