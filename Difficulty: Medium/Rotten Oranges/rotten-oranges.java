//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0; // No fresh oranges to rot
        }

        int time = 0; // Time counter
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Directions for BFS

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int x = orange[0];
                int y = orange[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2; // Rot the fresh orange
                        queue.offer(new int[] {nx, ny});
                        freshCount--;
                        rottedThisRound = true;
                    }
                }
            }

            if (rottedThisRound) {
                time++;
            }
        }

   
        return (freshCount == 0) ? time : -1;
    }
}