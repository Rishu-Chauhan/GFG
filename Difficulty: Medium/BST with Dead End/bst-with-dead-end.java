/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    
    
    public boolean isDeadEnd(Node root) {
    return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }
     private boolean checkDeadEnd(Node node, int min, int max) {
        if (node == null) return false;

        // If range collapses, it's a dead end
        if (min == max) return true;

        // Recursively check left and right subtrees
        return checkDeadEnd(node.left, min, node.data - 1) || 
               checkDeadEnd(node.right, node.data + 1, max);
    
     }
}