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
    public ListNode deleteMiddle(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            n++;
        }
        if(n == 1) return null;
        curr = head;
        for(int i = 0; i < n/2-1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}