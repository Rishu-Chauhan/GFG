/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
           Node newNode = new Node(data);

      
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;

        if (data <= head.data) {
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.next = head;
            return newNode; 
        }

        
        while (curr.next != head && curr.next.data < data) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
        
        return head;
    }
}