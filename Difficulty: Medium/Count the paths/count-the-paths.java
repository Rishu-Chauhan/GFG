class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> memo = new HashMap<>();

        // Build adjacency list
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        
        return dfs(graph, src, dest, memo);
    }
    
     private int dfs(Map<Integer, List<Integer>> graph, int node, int dest, Map<Integer, Integer> memo) {
        if (node == dest) return 1; // Found a path
        if (memo.containsKey(node)) return memo.get(node); // Use cached result

        int count = 0;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                count += dfs(graph, neighbor, dest, memo); // Recursive DFS
            }
        }

        memo.put(node, count); // Store computed result
        return count;
     }
}