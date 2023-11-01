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
        Node curr = head;
        while(curr != null){
            Node newPtr = new Node(curr.val);
            newPtr.next = curr.next;
            curr.next = newPtr;
            curr = newPtr.next;
        }

        curr = head;
        //interweave
        while(curr != null){
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }

        //outerweave
        Node new_head = head.next, oldPtr = head, newPtr = head.next;
        while(oldPtr != null){
            oldPtr.next = oldPtr.next.next;
            newPtr.next = newPtr.next != null ? newPtr.next.next : null;
            oldPtr = oldPtr.next;
            newPtr = newPtr.next;
        }
        return new_head;
    }
}