//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {

    public int minCost(int[][] houses) {
        // code here
         int n = houses.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{0, 0});

        int totalCost = 0;
        int visitedCount = 0;

        while (!pq.isEmpty() && visitedCount < n) {
            int[] current = pq.poll();
            int houseIdx = current[0];
            int cost = current[1];

            if (visited[houseIdx]) continue;

           
            visited[houseIdx] = true;
            totalCost += cost;
            visitedCount++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int manhattanDistance = Math.abs(houses[houseIdx][0] - houses[i][0]) +
                                            Math.abs(houses[houseIdx][1] - houses[i][1]);
                    pq.offer(new int[]{i, manhattanDistance});
                }
            }
        }

        return totalCost;
    }
}
