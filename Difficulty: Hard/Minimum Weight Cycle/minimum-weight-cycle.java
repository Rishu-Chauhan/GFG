//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
  
    public int findMinCycle(int V, int[][] edges) {
        // code here
         ArrayList<ArrayList<int[]>> adj = constructAdj(V, edges);

        int minCycle = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            
            // Find shortest path between u and v (excluding the edge itself)
            int dist = shortestPath(V, adj, u, v, edge);
            if (dist != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist + w);
            }
        }

        // Return the result
        return (minCycle == Integer.MAX_VALUE) ? -1 : minCycle;
    }

    private ArrayList<ArrayList<int[]>> constructAdj(int V, int[][] edges) {
        // Create adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        return adj;
    }

    private int shortestPath(int V, ArrayList<ArrayList<int[]>> adj, int src, int dest, int[] excludedEdge) {
        // Use Dijkstra's Algorithm to find the shortest path from src to dest
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        dist[src] = 0;
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];
                
                // Skip the excluded edge
                if ((node == excludedEdge[0] && next == excludedEdge[1]) || 
                    (node == excludedEdge[1] && next == excludedEdge[0])) {
                    continue;
                }

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
        return dist[dest];
    }
};