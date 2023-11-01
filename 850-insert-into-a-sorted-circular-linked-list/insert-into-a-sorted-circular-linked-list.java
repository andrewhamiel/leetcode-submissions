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
        //Case 0: Empty List
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node curr = head, nextNode = head.next, original = head;
        boolean isInserted = false;
        while(!isInserted){
            //3 Cases
            if((curr.val != nextNode.val) && 
            (curr.val <= insertVal && nextNode.val >= insertVal && curr.val <= nextNode.val //1. In Between
            || curr.val <= insertVal && nextNode.val <= insertVal && curr.val >= nextNode.val //2. Max at end
            || curr.val >= insertVal && nextNode.val >= insertVal && curr.val >= nextNode.val)){ // Min at beginning 
                Node ans = new Node(insertVal);
                ans.next = curr.next;
                curr.next = ans;
                return head;
            }
            curr = curr.next;
            nextNode = nextNode.next;
            if(curr == original) isInserted = true; 
        }
        //If all elements being inserted are the same, can add after first element in beginning
        Node ans = new Node(insertVal);
        ans.next = original.next;
        original.next = ans;
        return original;
    }
}