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
        if(head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node curr = head;
        boolean isFirst = false;
        while(!isFirst) {
            if((curr.val != curr.next.val) &&
                (curr.val < curr.next.val && curr.val <= insertVal && insertVal <= curr.next.val)
                || (curr.val > curr.next.val && curr.val <= insertVal && insertVal >= curr.next.val)
                || (curr.val > curr.next.val && curr.val >= insertVal && insertVal <= curr.next.val)) {
                    Node node = new Node(insertVal);
                    node.next = curr.next;
                    curr.next = node;
                    return head;
                }
            curr = curr.next;
            if(curr == head) isFirst = true;
        }

        //Case 4: all nodes have same value
        Node node = new Node(insertVal);
        node.next = head.next;
        head.next = node;
        return head;
    }
}