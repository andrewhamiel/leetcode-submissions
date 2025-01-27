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
        ListNode curr = head, prev = head;
        int size = 0;
        while(curr != null) {
            
            if(size - n > 0) prev = prev.next;
            curr = curr.next;            
            size++;
        }

        if(size == n) head = head.next;
        else prev.next = prev.next.next;
        return head;
    }
}