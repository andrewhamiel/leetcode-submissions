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
        //First, link old/new together. A -> A' -> B -> B' ->C ->C'
        Node curr = head;
        while(curr != null){
            Node new_ptr = new Node(curr.val);
            new_ptr.next = curr.next;
            curr.next = new_ptr;
            curr = new_ptr.next;
        }
        //Set randoms
        curr = head;
        while(curr != null){
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }
        //Unweave
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