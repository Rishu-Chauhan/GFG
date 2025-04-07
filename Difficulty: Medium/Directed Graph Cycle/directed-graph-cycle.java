//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
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
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    private boolean Cycle(int node,List<List<Integer>> adj,boolean path[],boolean visited[]){
        visited[node]=true;
        path[node]=true;
        for(int neigh:adj.get(node)){
            if(path[neigh]){
                return true;
            }
            if(!visited[neigh] && Cycle(neigh,adj,path,visited)){
                return true;
            }
        }
        path[node]=false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

      
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean path[]=new boolean[V];
        boolean visited[]=new boolean[V];
        
        for(int i=0;i<V;i++){
        if(!visited[i] && Cycle(i,adj,path,visited)){
                return true;
            }
        }
        return false;
    }
}