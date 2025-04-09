//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // Step 1: Build adjacency list
         
          List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Step 2: Initialize necessary variables
    boolean[] visited = new boolean[V];
    int[] disc = new int[V]; // Discovery times of visited vertices
    int[] low = new int[V]; // Lowest points reachable
    int[] parent = new int[V]; // Parent vertices in DFS tree
    Arrays.fill(parent, -1); // Initialize parent array with -1
    HashSet<Integer> articulationPoints = new HashSet<>();
    int[] time = new int[]{0}; // Time variable as an array for mutability

    // Step 3: Perform DFS for each component
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            dfs(i, visited, disc, low, parent, articulationPoints, adj, time);
        }
    }

    // Convert HashSet to ArrayList and sort it
    ArrayList<Integer> result = new ArrayList<>(articulationPoints);
    if (result.isEmpty()) {
        result.add(-1);
    } else {
        result.sort(Integer::compareTo);
    }
    return result;
}

static void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, 
                HashSet<Integer> articulationPoints, List<List<Integer>> adj, int[] time) {
    visited[u] = true;
    disc[u] = low[u] = ++time[0];
    int children = 0;

    for (int v : adj.get(u)) {
        if (!visited[v]) {
            parent[v] = u;
            children++;
            dfs(v, visited, disc, low, parent, articulationPoints, adj, time);

            // Check if the subtree rooted at v has a connection back to one of the ancestors of u
            low[u] = Math.min(low[u], low[v]);

            // Check if u is an articulation point
            if (parent[u] == -1 && children > 1) {
                articulationPoints.add(u);
            }
            if (parent[u] != -1 && low[v] >= disc[u]) {
                articulationPoints.add(u);
            }
        } else if (v != parent[u]) { // Update low value of u for parent function calls
            low[u] = Math.min(low[u], disc[v]);
        }
    }

    }
}
