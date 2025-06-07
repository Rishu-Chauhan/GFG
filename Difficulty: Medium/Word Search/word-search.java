class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
         int n = mat.length;
        int m = mat[0].length;
     
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    // Start DFS from this cell
                    if (dfs(mat, word, i, j, 0, new boolean[n][m])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
     private static boolean dfs(char[][] mat, String word, int i, int j, int index, boolean[][] visited) {
 
        if (index == word.length()) {
            return true;
        }

     
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j] || mat[i][j] != word.charAt(index)) {
            return false;
        }

       
        visited[i][j] = true;

      
        boolean found = dfs(mat, word, i + 1, j, index + 1, visited) || // Down
                        dfs(mat, word, i - 1, j, index + 1, visited) || // Up
                        dfs(mat, word, i, j + 1, index + 1, visited) || // Right
                        dfs(mat, word, i, j - 1, index + 1, visited);   // Left

      
        visited[i][j] = false;

        return found;
     }
}