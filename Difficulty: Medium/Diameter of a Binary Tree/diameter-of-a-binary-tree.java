

// User function Template for Java

/*class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class Solution {
    
      class TreeInfo {
        int height;
        int diameter;
        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
   
    int diameter(Node root) {
     return diameterHelper(root).diameter;
        
    }
    private TreeInfo diameterHelper(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

      
        TreeInfo left = diameterHelper(root.left);
        TreeInfo right = diameterHelper(root.right);

        
        int height = Math.max(left.height, right.height) + 1;

        
        int selfDiameter = left.height + right.height;
        int maxDiameter = Math.max(selfDiameter, Math.max(left.diameter, right.diameter));

        return new TreeInfo(height, maxDiameter);
    }
}
