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
        if(head == null) return null;
        //1. Interweave
        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        //2. Copy randoms
        curr = head;
        while(curr != null && curr.next != null) {
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }
        //3. Outerweave
        Node oldPtr = head, newPtr = head.next, newHead = newPtr;
        while(oldPtr != null && newPtr != null) {
            oldPtr.next = newPtr.next;
            newPtr.next = newPtr.next == null ? null : newPtr.next.next;
            oldPtr = oldPtr.next;
            newPtr = newPtr.next;
        }
        return newHead;
    }
}