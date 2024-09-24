/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node curr = head;
        while(curr != null) {
            Node nextNode = new Node(curr.val);
            nextNode.next = curr.next;
            curr.next = nextNode;
            curr = curr.next.next;
        }

        //Interweave
        curr = head;
        while(curr != null) {
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }

        //Outerweave
        Node oldPtr = head, newPtr = head.next, newHead = newPtr;
        while(oldPtr != null) {
            oldPtr.next = oldPtr.next.next;
            newPtr.next = newPtr.next != null ? newPtr.next.next : null;
            oldPtr = oldPtr.next;
            newPtr = newPtr.next;
        }
        return newHead;
        
    }
}