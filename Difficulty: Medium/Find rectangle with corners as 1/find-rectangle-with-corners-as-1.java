class Solution {
    public boolean ValidCorner(int mat[][]) {
        // Code here
         int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns

     
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                if (mat[i][j] == 1) {  
                    for (int k = j + 1; k < m; k++) { 
                        if (mat[i][k] == 1) {  
                          
                            if (map.containsKey(j) && map.get(j).contains(k)) {
                                return true;
                            }

                          
                            map.putIfAbsent(j, new HashSet<>());
                            map.get(j).add(k);
                        }
                    }
                }
            }
        }

        return false;
    }
}