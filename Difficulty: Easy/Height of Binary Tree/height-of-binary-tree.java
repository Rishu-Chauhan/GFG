/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
         return node == null ? -1 : 1 + Math.max(height(node.left), height(node.right));
    }
}