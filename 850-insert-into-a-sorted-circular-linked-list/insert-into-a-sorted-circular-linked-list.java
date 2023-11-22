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
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node curr = head;
        boolean isLoopCompleted = false;
        while(!isLoopCompleted){
            //Case 1: in between two elements
            //Case 2: End of list, max element
            //Case 3: End of list, minimum element
            if((curr.val != curr.next.val) &&
            ((curr.val <= insertVal && curr.next.val >= insertVal && curr.val <= curr.next.val)
            || (curr.val <= insertVal && curr.next.val <= insertVal && curr.val >= curr.next.val)
            || (curr.val >= insertVal && curr.next.val >= insertVal && curr.val >= curr.next.val))){
                Node node = new Node(insertVal);
                node.next = curr.next;
                curr.next = node;
                return head;
            }
            curr = curr.next;
            if(curr == head) isLoopCompleted = true;
        }
        //Case 4: all duplicates. insert after first element
        Node node = new Node(insertVal);
        curr = head;
        node.next = curr.next;
        curr.next = node;
        return head;
    }
}