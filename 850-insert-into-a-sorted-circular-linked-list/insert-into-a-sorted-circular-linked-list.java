/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node curr = head;
        boolean isInserted = false;
        while(!isInserted){
            if((curr.val != curr.next.val) && 
            ((curr.val <= insertVal && insertVal <= curr.next.val && curr.val <= curr.next.val)
            || (curr.val <= insertVal && curr.next.val <= insertVal && curr.val >= curr.next.val)
            || (curr.val >= insertVal && curr.next.val >= insertVal && curr.val >= curr.next.val))){
                Node node = new Node(insertVal);
                node.next = curr.next;
                curr.next = node;
                return head;
            }
            curr = curr.next;
            if(curr == head) isInserted = true;
        }
        //case 4: all duplicates
        curr = head;
        Node node = new Node(insertVal);
        node.next = curr.next;
        curr.next = node;
        return head;
    }
}