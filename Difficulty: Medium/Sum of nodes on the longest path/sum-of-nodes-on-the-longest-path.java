/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
     private class Pair {
        int maxSum;
        int maxLength;
        
        Pair(int maxSum, int maxLength) {
            this.maxSum = maxSum;
            this.maxLength = maxLength;
        }
    }
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
          if (root == null) return 0;
        
        Pair result = helper(root, 0, 0);
        return result.maxSum;
    }
     private Pair helper(Node node, int currentSum, int currentLength) {
        if (node == null) return new Pair(currentSum, currentLength);

        currentSum += node.data;
        currentLength++;

        Pair left = helper(node.left, currentSum, currentLength);
        Pair right = helper(node.right, currentSum, currentLength);

        if (left.maxLength > right.maxLength) return left;
        else if (right.maxLength > left.maxLength) return right;
        else return left.maxSum > right.maxSum ? left : right;
    }
}