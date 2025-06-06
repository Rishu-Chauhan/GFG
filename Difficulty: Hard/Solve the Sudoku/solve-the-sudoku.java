// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
         solve(mat, 0, 0);
    }
     private static boolean solve(int[][] mat, int row, int col) {
        if (row == 9) return true; // Puzzle solved
        if (col == 9) return solve(mat, row + 1, 0); // Move to next row

        if (mat[row][col] != 0) return solve(mat, row, col + 1); // Skip fixed values

        for (int num = 1; num <= 9; num++) {
            if (isValid(mat, row, col, num)) {
                mat[row][col] = num;
                if (solve(mat, row, col + 1)) return true;
                mat[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    private static boolean isValid(int[][] mat, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == num || mat[i][col] == num) return false;
            if (mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
        }
        return true;
    }
}