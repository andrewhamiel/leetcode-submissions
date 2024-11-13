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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            size++;
        }

        ListNode[] result = new ListNode[k];
        int parts = size/k, rem = size % k;
        curr = head;
        for(int i = 0; i < k; i++) {
            ListNode ptr = curr;
            int carry = i < rem ? 1 : 0;
            for(int j = 0; j < parts + carry - 1; j++) {
                 if(curr != null) curr = curr.next;
            }

            //Delink at end 
            if(curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            result[i] = ptr;
        }
        return result;
    }
}