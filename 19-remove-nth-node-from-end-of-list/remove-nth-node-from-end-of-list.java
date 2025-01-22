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
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }

        if(size - n == 0) return head.next;

        int currNode = 1;
        curr = head;
        while(curr != null && currNode < size - n) {
            curr = curr.next;
            currNode++;
        }

        curr.next = curr.next.next;
        return head;
    }
}