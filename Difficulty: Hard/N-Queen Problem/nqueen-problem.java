// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int[] board = new int[n]; // board[i] represents row where queen is placed in column i
        solve(0, board, results, n);
        return results;
    }
    
    private void solve(int col, int[] board, ArrayList<ArrayList<Integer>> results, int n) {
        if (col == n) { // All queens are placed
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1); // Convert 0-based row index to 1-based
            }
            results.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(col, row, board)) {
                board[col] = row; // Place queen
                solve(col + 1, board, results, n); // Move to next column
            }
        }
    }

    private boolean isSafe(int col, int row, int[] board) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false; // Same row or same diagonal
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nQueen(4)); // Example: solving for n = 4
    }

}