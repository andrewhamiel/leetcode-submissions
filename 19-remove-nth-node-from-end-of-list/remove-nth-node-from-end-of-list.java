/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1. Find size
        int size = 0;
        ListNode curr =  head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        //2. Remove nth node
        curr = head;
        //Advance to pointer before nth node
        for(int currNode = 1; currNode < size - n; currNode++) {
            curr = curr.next;
        }
        //3. Link to nth + 1 node if present
        if(size == n) head = head.next;
        else curr.next = curr.next.next;
        return head;
    }
}