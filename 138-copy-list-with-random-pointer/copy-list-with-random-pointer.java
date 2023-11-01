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
        //Interweave
        Node curr = head;
        while(curr != null){
            Node tmp = new Node(curr.val);
            tmp.next = curr.next;
            curr.next = tmp;
            curr = tmp.next;
        }

        curr = head;
        while(curr != null){
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }

        //Outerweave
        Node newHead = head.next, oldPtr = head, newPtr = head.next;
        while(oldPtr != null){
            oldPtr.next = oldPtr.next.next;
            newPtr.next = newPtr.next != null ? newPtr.next.next : null;
            oldPtr = oldPtr.next;
            newPtr = newPtr.next;
        }
        return newHead;
    }
}