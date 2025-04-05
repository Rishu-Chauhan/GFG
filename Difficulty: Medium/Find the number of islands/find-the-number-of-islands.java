//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countIslands(char[][] grid) {
          int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] visited= new boolean[n][m];
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(!visited[i][j] && grid[i][j]=='L'){
                    count++;
                    bfs(i,j,visited,grid);
                }
            }
        }
        return count;
    }
    
    private void bfs(int i,int j, boolean[][] visited, char[][] grid){
        visited[i][j]=true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i , j});
        
        int n=grid.length;
        int m=grid[0].length;
        
        int [] di= {-1,-1,-1, 0,0, 1,1,1};
        int [] dj= {-1, 0, 1, -1,1 , -1,0,1};
        
        while(!q.isEmpty()){
            int[] cell=q.poll();
            
            int row=cell[0];
            int col=cell[1];
            
            for(int ii=0;ii<8;ii++){
                int newR= row + di[ii];
                int newC= col+ dj[ii];
                
                if(newR>=0 && newR<n && newC>=0 && newC<m && grid[newR][newC]=='L' && !visited[newR][newC]){
                    visited[newR][newC]=true;
                    
                    q.add(new int[]{newR, newC});
                }
            }
        }
    }
        
    
}