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
        int size = 1;
        ListNode curr = head;
        while(curr.next != null){
            size++;
            curr = curr.next;
        }
        int idx = size - n; // Node before the one to be removed.
        // reset counter and curr
        size = 1; curr = head;
        if(idx == 0) return head.next;
        while(size != idx){
            size++;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}