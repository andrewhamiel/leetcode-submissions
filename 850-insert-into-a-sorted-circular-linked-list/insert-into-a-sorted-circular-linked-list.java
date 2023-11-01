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
        //Case 0: head is null
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node curr = head, nextNode = head.next;
        boolean isInserted = false;
        while(!isInserted){
            //3 Cases:
            //1. In between curr and nextNode
            //2. Max element at end
            //3. Min element at beginning
            if((curr.val != nextNode.val) &&
            ((curr.val <= insertVal && nextNode.val >= insertVal && curr.val <= nextNode.val)
            || (curr.val <= insertVal && nextNode.val <= insertVal && curr.val >= nextNode.val)
            || (curr.val >= insertVal && nextNode.val >= insertVal && curr.val >= nextNode.val))){
                Node ans = new Node(insertVal);
                ans.next = curr.next;
                curr.next = ans;
                return head;
            }
            curr = curr.next;
            nextNode = nextNode.next;
            if(curr == head) isInserted = true;
        }
        //Case 4: All duplicates. If we reach this point, can insert after first element
        curr = head;
        Node ans = new Node(insertVal);
        ans.next = curr.next;
        curr.next = ans;
        return head;
    }
}