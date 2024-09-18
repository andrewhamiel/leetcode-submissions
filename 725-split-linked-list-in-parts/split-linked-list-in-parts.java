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
        ListNode curr = head;
        int nodes = 0;
        while(curr != null) {
            curr = curr.next;
            nodes++;
        }

        int width = nodes/k, rem = nodes % k;
        ListNode[] result = new ListNode[k];
        curr = head;

        for(int i = 0; i < k; i++) {
            ListNode ptr = curr;
            int carry = i < rem ? 1 : 0;
            for(int j = 0; j < width + carry - 1; j++) {
                if(curr != null) curr = curr.next;
            }

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